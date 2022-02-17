package com.example.studentsrest;

import com.example.studentsrest.entities.Classroom;
import com.example.studentsrest.entities.Discipline;
import com.example.studentsrest.entities.Group;
import com.example.studentsrest.entities.Timetable;
import com.example.studentsrest.repositories.TimetableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.sql.Time;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TimetableTests {
    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreatingTimetable() {
        Timetable timetable = new Timetable();

        Classroom classroom = entityManager.find(Classroom.class, 1L);
        Discipline discipline = entityManager.find(Discipline.class, 1L);
        Group group = entityManager.find(Group.class, 1L);

        timetable.setDate(new Date(System.currentTimeMillis()));
        timetable.setTime(new Time(System.currentTimeMillis()));
        timetable.setClassroom(classroom);
        timetable.setDiscipline(discipline);
        timetable.setGroup(group);
        timetableRepository.save(timetable);
    }

    @Test
    public void testUpdatingTimetable() {
        //
    }

    @Test
    public void testDeletingTimetable() {
        //
    }
}
