// package com.example.springboot.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;

// import com.example.springboot.dto.ApiResponse;

// @ControllerAdvice
// public class StudentNotFoundResponse {

//     @SuppressWarnings("rawtypes")
//     @ExceptionHandler(StudentNotFoundException.class)
//     @ResponseStatus(HttpStatus.NOT_FOUND)
//     @ResponseBody
//     private ApiResponse studentNotFoundHandler(StudentNotFoundException exception) {
//         return new ApiResponse<>( HttpStatus.NOT_FOUND,
//             HttpStatus.NOT_FOUND.toString(), exception.getMessage());
//     }
// }
