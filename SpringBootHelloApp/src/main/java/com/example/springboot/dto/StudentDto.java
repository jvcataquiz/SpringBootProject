package com.example.springboot.dto;

import java.util.List;

public class StudentDto {

	 String studentName;
     String year;
     List<CourseDto> courses;
	 public String getStudentName() {
		 return studentName;
	 }
	 public void setStudentName(String studentName) {
		 this.studentName = studentName;
	 }
	 public String getYear() {
		 return year;
	 }
	 public void setYear(String year) {
		 this.year = year;
	 }
	 public List<CourseDto> getCourses() {
		 return courses;
	 }
	 public void setCourses(List<CourseDto> courses) {
		 this.courses = courses;
	 }
	
}
