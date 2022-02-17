package com.example.studentsrest.services;

import com.example.studentsrest.entities.Discipline;

import java.util.List;

public interface DisciplineService {
    List<Discipline> getAll();

    Discipline getById(Long id);

    Discipline save(Discipline discipline);

    void delete(Long id);
}
