package com.example.studentsrest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student_groups")
public class Group {
    private long id;
    private String groupNumber;
    private Set<Student> students = new HashSet<>();
    private Set<Timetable> timetables = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "group_number")
    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    public Set<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(Set<Timetable> timetables) {
        this.timetables = timetables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id && Objects.equals(groupNumber, group.groupNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupNumber);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupNumber='" + groupNumber + '\'' +
                '}';
    }
}
