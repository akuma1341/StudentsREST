package com.example.studentsrest;

import com.example.studentsrest.entities.Discipline;
import com.example.studentsrest.entities.Teacher;
import com.example.studentsrest.repositories.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TeacherTests {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreatingTeacher() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Firstname");
        teacher.setLastName("Lastname");

        Discipline discipline = entityManager.find(Discipline.class, 2L);
        System.out.println(discipline);
        teacher.addDiscipline(discipline);
        teacherRepository.save(teacher);
    }

    @Test
    public void testUpdatingTeacher() {
        long teacherId = 1L;
        Teacher teacher = entityManager.find(Teacher.class, teacherId);
        teacher.setFirstName("FirstnameUpdated");
        teacher.setLastName("LastnameUpdated");
        teacherRepository.save(teacher);
    }

    @Test
    public void testDeletingTeacher() {
        long teacherId = 1L;
        teacherRepository.deleteById(teacherId);
    }
}
