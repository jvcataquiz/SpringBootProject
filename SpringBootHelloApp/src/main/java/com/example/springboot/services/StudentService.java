package com.example.springboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.StudentDto;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;
import com.example.springboot.exception.StudentNotFoundException;
import com.example.springboot.repository.CourseRepository;
import com.example.springboot.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Cacheable("students")
	public List<Student> retrieveAllStudent() {
		List<Student> students = new ArrayList<>();
		try {
			// Thread.sleep(3000);
			students = studentRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	@Cacheable(value = "student", key = "#p0")
	public Object getStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent()) {
			return new StudentNotFoundException("Resource with ID " + id + " not found");
		}
		return student;
	}

	@CacheEvict(value = "students", allEntries = true)
	public void createStudent(StudentDto studentDto) {
		Student student = new Student();
		student.setStudentName(studentDto.getStudentName());
		student.setStudentYear(studentDto.getYear());
		studentRepository.save(student);
		List<Course> courseEntities = studentDto.getCourses().stream()
				.map(dto -> {
					Course course = new Course();
					course.setName(dto.getName());
					course.setDescription(dto.getDescription());
					course.setStudent(student);
					return course;
				})
				.collect(Collectors.toList());

		courseRepository.saveAll(courseEntities);
	}

}
