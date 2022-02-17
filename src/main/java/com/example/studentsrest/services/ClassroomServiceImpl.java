package com.example.studentsrest.services;

import com.example.studentsrest.entities.Classroom;
import com.example.studentsrest.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> getAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom getById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    @Override
    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public void delete(Long id) {
        classroomRepository.deleteById(id);
    }
}
