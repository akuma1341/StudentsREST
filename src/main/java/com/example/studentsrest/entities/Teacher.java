package com.example.studentsrest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher {
    private long id;
    private String firstName;
    private String lastName;
    private Set<Discipline> disciplines = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany
    @JoinTable(name = "teachers_disciplines",
            joinColumns = @JoinColumn(name = "id_teacher"),
            inverseJoinColumns = @JoinColumn(name = "id_discipline"))
    @JsonBackReference
    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public void addDiscipline(Discipline discipline) {
        this.disciplines.add(discipline);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(firstName, teacher.firstName) && Objects.equals(lastName, teacher.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
