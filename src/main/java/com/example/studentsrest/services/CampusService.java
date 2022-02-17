package com.example.studentsrest.services;

import com.example.studentsrest.entities.Campus;

import java.util.List;

public interface CampusService {
    List<Campus> getAll();

    Campus getById(Long id);

    void save(Campus campus);

    void delete(Long id);
}
