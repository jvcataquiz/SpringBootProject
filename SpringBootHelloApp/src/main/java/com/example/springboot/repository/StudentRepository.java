package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
