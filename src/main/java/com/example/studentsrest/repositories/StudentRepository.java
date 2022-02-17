package com.example.studentsrest.repositories;

import com.example.studentsrest.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
