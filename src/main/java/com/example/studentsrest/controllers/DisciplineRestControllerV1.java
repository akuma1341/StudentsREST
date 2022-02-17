package com.example.studentsrest.controllers;

import com.example.studentsrest.entities.Discipline;
import com.example.studentsrest.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/disciplines/")
public class DisciplineRestControllerV1 {
    @Autowired
    private DisciplineService disciplineService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Discipline>> getAllDisciplines() {
        List<Discipline> disciplines = this.disciplineService.getAll();

        if (disciplines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(disciplines, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Discipline> getDisciplineById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Discipline discipline = this.disciplineService.getById(id);

        if (discipline == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(discipline, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        if (discipline == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.disciplineService.save(discipline);
        return new ResponseEntity<>(discipline, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Discipline> updateDiscipline(@RequestBody Discipline discipline) {
        if (discipline == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.disciplineService.save(discipline);

        return new ResponseEntity<>(discipline, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Discipline> deleteDiscipline(@PathVariable("id") Long id) {
        Discipline discipline = this.disciplineService.getById(id);

        if (discipline == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.disciplineService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
