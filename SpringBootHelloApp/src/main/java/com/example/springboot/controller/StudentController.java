package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.StudentDto;
import com.example.springboot.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping()
	public Object retrieveAllStudent() {
		return studentService.retrieveAllStudent();
	}

	@GetMapping("/{id}")
	public Object getStudent(@PathVariable Long id) {
		return studentService.getStudent(id); 
	}

	@PostMapping("/create")
	public void createStudent(@RequestBody StudentDto studentDto) {
		studentService.createStudent(studentDto); 
	}
}
