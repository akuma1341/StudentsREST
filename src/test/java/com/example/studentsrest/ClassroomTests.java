package com.example.studentsrest;

import com.example.studentsrest.entities.Campus;
import com.example.studentsrest.entities.Classroom;
import com.example.studentsrest.repositories.ClassroomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ClassroomTests {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreatingClassroom() {
        Campus campus = entityManager.find(Campus.class, 2L);
        Classroom classroom = new Classroom();
        classroom.setCampus(campus);
        classroom.setNumber(1);
        classroomRepository.save(classroom);
    }

    @Test
    public void testUpdatingClassroom() {
        Classroom classroom = entityManager.find(Classroom.class, 3L);
        classroom.setNumber(2);
        classroomRepository.save(classroom);
    }

    @Test
    public void testDeletingClassroom() {
        classroomRepository.deleteById(3L);
    }
}
