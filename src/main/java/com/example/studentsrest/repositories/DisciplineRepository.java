package com.example.studentsrest.repositories;

import com.example.studentsrest.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
