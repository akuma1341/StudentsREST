package com.example.studentsrest.services;

import com.example.studentsrest.entities.Discipline;
import com.example.studentsrest.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    @Autowired
    private DisciplineRepository disciplineRepository;

    @Override
    public List<Discipline> getAll() {
        return disciplineRepository.findAll();
    }

    @Override
    public Discipline getById(Long id) {
        return disciplineRepository.findById(id).orElse(null);
    }

    @Override
    public Discipline save(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    @Override
    public void delete(Long id) {
        disciplineRepository.deleteById(id);
    }
}
