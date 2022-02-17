package com.example.studentsrest.services;

import com.example.studentsrest.entities.Campus;
import com.example.studentsrest.repositories.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusServiceImpl implements CampusService {
    @Autowired
    private CampusRepository campusRepository;

    @Override
    public List<Campus> getAll() {
        return campusRepository.findAll();
    }

    @Override
    public Campus getById(Long id) {
        return campusRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Campus campus) {
        campusRepository.save(campus);
    }

    @Override
    public void delete(Long id) {
        campusRepository.deleteById(id);
    }
}
