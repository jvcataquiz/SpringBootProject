package com.example.springboot.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.springboot.dto.ApiResponse;
import com.example.springboot.exception.StudentNotFoundException;

@Aspect
@Component
public class ApiResponseWrappingAspect {

	@Around(value = "execution(* com.example.springboot.controller..*.*(..))")
	public Object wrapApiResponse(ProceedingJoinPoint pjp) throws Throwable {
		Object ret = pjp.proceed();
		if (ret instanceof StudentNotFoundException) {
			StudentNotFoundException ex = (StudentNotFoundException) ret;
			return createExceptionResponse(ex, HttpStatus.NOT_FOUND);
		}
		return new ApiResponse<>(HttpStatus.OK, "success", ret);
	}

	private Object createExceptionResponse(Exception ex, HttpStatus status) {
			Map<String, Object> messageBody = new HashMap<>();
			messageBody.put("error", "Not Found");
			messageBody.put("message", ex.getMessage());
			return new ApiResponse<>(status,
					status.toString(), messageBody);
	}
}
