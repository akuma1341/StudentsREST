package com.example.studentsrest.repositories;

import com.example.studentsrest.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
