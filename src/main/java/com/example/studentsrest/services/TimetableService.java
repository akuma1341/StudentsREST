package com.example.studentsrest.services;

import com.example.studentsrest.entities.Timetable;

import java.util.List;

public interface TimetableService {
    List<Timetable> getAll();

    Timetable getById(Long id);

    void save(Timetable timetable);

    void delete(Long id);
}
