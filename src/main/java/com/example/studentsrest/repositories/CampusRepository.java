package com.example.studentsrest.repositories;

import com.example.studentsrest.entities.Campus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusRepository extends JpaRepository<Campus, Long> {
}
