package com.example.studentsrest;

import com.example.studentsrest.entities.Campus;
import com.example.studentsrest.repositories.CampusRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CampusTests {
    @Autowired
    private CampusRepository campusRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreatingCampus() {
        Campus campus = new Campus();
        campus.setName("TestName");
        campus.setNumber(1);
        campusRepository.save(campus);
    }

    @Test
    public void testUpdatingCampus() {
        Campus campus = entityManager.find(Campus.class, 3L);
        campus.setName("NewName");
        campus.setNumber(2);
        campusRepository.save(campus);
    }

    @Test
    public void testDeletingCampus() {
        campusRepository.deleteById(3L);
    }
}
