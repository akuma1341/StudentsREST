package com.example.studentsrest.controllers;

import com.example.studentsrest.entities.Timetable;
import com.example.studentsrest.services.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/timetables/")
public class TimetableRestControllerV1 {
    @Autowired
    private TimetableService timetableService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Timetable>> getAllTimetables() {
        List<Timetable> timetables = this.timetableService.getAll();

        if (timetables.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(timetables, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Timetable> getTimetableById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Timetable timetable = this.timetableService.getById(id);

        if (timetable == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(timetable, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Timetable> saveTimetable(@RequestBody Timetable timetable) {
        if (timetable == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.timetableService.save(timetable);
        return new ResponseEntity<>(timetable, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Timetable> updateTimetable(@RequestBody Timetable timetable) {
        if (timetable == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.timetableService.save(timetable);

        return new ResponseEntity<>(timetable, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Timetable> deleteTimetable(@PathVariable("id") Long id) {
        Timetable timetable = this.timetableService.getById(id);

        if (timetable == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.timetableService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
