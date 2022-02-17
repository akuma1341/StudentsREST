package com.example.studentsrest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "campuses")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Campus {
    private long id;
    private String name;
    private int number;
    private Set<Classroom> classrooms = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campus")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @OneToMany(mappedBy = "campus", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public void addClassroom(Classroom classroom) {
        this.classrooms.add(classroom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campus campus = (Campus) o;
        return id == campus.id && number == campus.number && Objects.equals(name, campus.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number);
    }

    @Override
    public String toString() {
        return "Campus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", classrooms=" + classrooms +
                '}';
    }
}
