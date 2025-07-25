package com.example.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;
import com.example.springboot.repository.CourseRepository;
import com.example.springboot.repository.StudentRepository;

@EnableCaching
@SpringBootApplication
public class SpringBootTestingApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create student without courses first (optional)
        Student s1 = new Student();
        s1.setStudentName("John Doe");
        s1.setStudentYear("Freshman");
       studentRepository.save(s1); 

     // Create and save courses linked to the student
        Course course1 = new Course("Intro to Java", "Java basics course", s1);
        Course course2 = new Course("Spring Boot", "Build APIs using Spring Boot", s1);



      courseRepository.saveAll(List.of(course1, course2));

        System.out.println("Dummy data inserted with student and courses.");
	}
}
