package com.example.studentsrest.services;

import com.example.studentsrest.entities.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAll();

    Group getById(Long id);

    void save(Group group);

    void delete(Long id);
}
