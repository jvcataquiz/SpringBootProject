package com.example.springboot.exception;

// @ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException  {
    //  public StudentNotFoundException(Long studentId) {
    //     super("Student not found with id: " + studentId);
    // }


    public StudentNotFoundException(String message) {
        super(message);
    }

    
}