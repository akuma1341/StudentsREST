package com.example.studentsrest.repositories;

import com.example.studentsrest.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
