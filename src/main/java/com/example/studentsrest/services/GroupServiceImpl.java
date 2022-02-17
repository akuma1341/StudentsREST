package com.example.studentsrest.services;

import com.example.studentsrest.entities.Group;
import com.example.studentsrest.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group getById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}
