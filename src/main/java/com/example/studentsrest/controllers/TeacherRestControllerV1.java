package com.example.studentsrest.controllers;

import com.example.studentsrest.entities.Teacher;
import com.example.studentsrest.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers/")
public class TeacherRestControllerV1 {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = this.teacherService.getAll();

        if (teachers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Teacher teacher = this.teacherService.getById(id);

        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.teacherService.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.teacherService.save(teacher);

        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable("id") Long id) {
        Teacher teacher = this.teacherService.getById(id);

        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.teacherService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
