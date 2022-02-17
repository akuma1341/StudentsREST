package com.example.studentsrest.services;

import com.example.studentsrest.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    Student getById(Long id);

    void save(Student student);

    void delete(Long id);
}
