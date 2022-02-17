package com.example.studentsrest.controllers;

import com.example.studentsrest.entities.Classroom;
import com.example.studentsrest.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classrooms/")
public class ClassroomRestControllerV1 {
    @Autowired
    private ClassroomService classroomService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Classroom>> getAllClassrooms() {
        List<Classroom> classrooms = this.classroomService.getAll();

        if (classrooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Classroom> getClassroomById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Classroom classroom = this.classroomService.getById(id);

        if (classroom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Classroom> saveClassroom(@RequestBody Classroom classroom) {
        if (classroom == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.classroomService.save(classroom);
        return new ResponseEntity<>(classroom, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Classroom> updateClassroom(@RequestBody Classroom classroom) {
        if (classroom == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.classroomService.save(classroom);

        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Classroom> deleteClassroom(@PathVariable("id") Long id) {
        Classroom classroom = this.classroomService.getById(id);

        if (classroom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.classroomService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
