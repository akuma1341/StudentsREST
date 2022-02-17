package com.example.studentsrest.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "timetable")
public class Timetable {
    private long id;
    private Discipline discipline;
    private Teacher teacher;
    private Group group;
    private Classroom classroom;
    private Date date;
    private Time time;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_discipline")
    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_teacher")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_group")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_classroom")
    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return id == timetable.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
