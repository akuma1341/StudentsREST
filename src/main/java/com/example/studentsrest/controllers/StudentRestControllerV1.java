package com.example.studentsrest.controllers;

import com.example.studentsrest.entities.Student;
import com.example.studentsrest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentRestControllerV1 {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = this.studentService.getAll();

        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Student student = this.studentService.getById(id);

        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.studentService.save(student);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
        Student student = this.studentService.getById(id);

        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.studentService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
