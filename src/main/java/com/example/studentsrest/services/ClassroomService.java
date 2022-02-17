package com.example.studentsrest.services;

import com.example.studentsrest.entities.Classroom;

import java.util.List;

public interface ClassroomService {
    List<Classroom> getAll();

    Classroom getById(Long id);

    Classroom save(Classroom classroom);

    void delete(Long id);
}
