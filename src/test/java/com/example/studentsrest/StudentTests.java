package com.example.studentsrest;

import com.example.studentsrest.entities.Group;
import com.example.studentsrest.entities.Student;
import com.example.studentsrest.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class StudentTests {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreatingStudent() {
        Student student = new Student();
        student.setFirstName("Firstname");
        student.setLastName("Lastname");
        Group group = entityManager.find(Group.class, 1L);
        student.setGroup(group);
        studentRepository.save(student);
    }

    @Test
    public void testUpdatingStudent() {
        long studentId = 1L;
        Student student = entityManager.find(Student.class, studentId);
        student.setFirstName("FirstnameUpdated");
        student.setLastName("LastnameUpdated");
        studentRepository.save(student);
    }

    @Test
    public void testDeletingStudent() {
        long studentId = 1L;
        studentRepository.deleteById(studentId);
    }
}
