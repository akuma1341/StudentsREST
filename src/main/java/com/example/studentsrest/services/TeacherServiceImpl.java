package com.example.studentsrest.services;

import com.example.studentsrest.entities.Teacher;
import com.example.studentsrest.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }
}
