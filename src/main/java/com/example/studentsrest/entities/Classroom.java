package com.example.studentsrest.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "classrooms")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Classroom {
    private long id;
    private int number;
    private Campus campus;
    private Set<Timetable> timetables;

    public Classroom() {
    }

    public Classroom(int number, Campus campus) {
        this.number = number;
        this.campus = campus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classroom")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @ManyToOne
    @JoinColumn(name = "id_campus")
    @JsonManagedReference
    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    public Set<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(Set<Timetable> timetables) {
        this.timetables = timetables;
    }

    public void addTimetable(Timetable timetable) {
        this.timetables.add(timetable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id == classroom.id && number == classroom.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
