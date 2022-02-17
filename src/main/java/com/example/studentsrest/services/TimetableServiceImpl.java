package com.example.studentsrest.services;

import com.example.studentsrest.entities.Timetable;
import com.example.studentsrest.repositories.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {
    @Autowired
    private TimetableRepository timetableRepository;

    @Override
    public List<Timetable> getAll() {
        return timetableRepository.findAll();
    }

    @Override
    public Timetable getById(Long id) {
        return timetableRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Timetable timetable) {
        timetableRepository.save(timetable);
    }

    @Override
    public void delete(Long id) {
        timetableRepository.deleteById(id);
    }
}
