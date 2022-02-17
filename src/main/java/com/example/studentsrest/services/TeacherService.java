package com.example.studentsrest.services;

import com.example.studentsrest.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAll();

    Teacher getById(Long id);

    void save(Teacher teacher);

    void delete(Long id);
}
