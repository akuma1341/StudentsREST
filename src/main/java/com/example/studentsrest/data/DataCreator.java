package com.example.studentsrest.data;

import com.example.studentsrest.entities.*;
import com.example.studentsrest.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataCreator {
    private final CampusService campusService;
    private final ClassroomService classroomService;
    private final DisciplineService disciplineService;
    private final GroupService groupService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final TimetableService timetableService;

    private boolean needCreateData = false;

    @Autowired
    public DataCreator(CampusService campusService, ClassroomService classroomService,
                       DisciplineService disciplineService, GroupService groupService,
                       StudentService studentService, TeacherService teacherService,
                       TimetableService timetableService) {
        this.campusService = campusService;
        this.classroomService = classroomService;
        this.disciplineService = disciplineService;
        this.groupService = groupService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.timetableService = timetableService;
    }

    public void createTestDataIfNeeded() {
        if (this.needCreateData) {
            List<Classroom> classrooms = new ArrayList<>();
            Random random = new Random();
            for (int i = 1; i <= 20; i++) {
                Campus campus = new Campus();
                campus.setName("Campus" + i);
                campus.setNumber(i);
                campusService.save(campus);

                classrooms.clear();
                for (int j = 1; j <= 5; j++) {
                    Classroom classroom = new Classroom();
                    classroom.setNumber(j);
                    classroom.setCampus(campus);
                    classrooms.add(classroomService.save(classroom));
                }

                Discipline discipline = new Discipline();
                discipline.setName("Discipline" + i);

                Teacher teacher = new Teacher();
                teacher.setFirstName("Teacher");
                teacher.setLastName("" + i);
                teacher.addDiscipline(disciplineService.save(discipline));
                teacherService.save(teacher);

                Group group = new Group();
                group.setGroupNumber("Group-" + i);
                groupService.save(group);

                for (int j = 1; j <= 5; j++) {
                    Student student = new Student();
                    student.setFirstName("Student");
                    student.setLastName("" + j);
                    student.setGroup(group);
                    studentService.save(student);
                }

                Timetable timetable = new Timetable();
                timetable.setDiscipline(discipline);
                timetable.setTeacher(teacher);
                timetable.setGroup(group);
                timetable.setClassroom(classrooms.get(random.nextInt(5)));
                timetable.setDate(Date.valueOf("2022-02-" + i));
                timetable.setTime(Time.valueOf(i + ":00:00"));
                timetableService.save(timetable);
            }
        }
    }

    public boolean isNeedCreateData() {
        return needCreateData;
    }

    public void setNeedCreateData(boolean needCreateData) {
        this.needCreateData = needCreateData;
    }
}
