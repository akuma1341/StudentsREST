package com.example.studentsrest.repositories;

import com.example.studentsrest.entities.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}
