package com.example.studentsrest;

import com.example.studentsrest.entities.Discipline;
import com.example.studentsrest.repositories.DisciplineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class DisciplineTests {
    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreatingDiscipline() {
        Discipline discipline = new Discipline();
        discipline.setName("Discipline1");
        disciplineRepository.save(discipline);
    }

    @Test
    public void testUpdatingDiscipline() {
        long disciplineId = 1L;
        Discipline discipline = entityManager.find(Discipline.class, disciplineId);
        discipline.setName("DisciplineUpdated");
        disciplineRepository.save(discipline);
    }

    @Test
    public void testDeletingDiscipline() {
        long disciplineId = 1L;
        disciplineRepository.deleteById(disciplineId);
    }
}
