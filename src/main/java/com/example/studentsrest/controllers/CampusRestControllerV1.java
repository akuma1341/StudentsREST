package com.example.studentsrest.controllers;

import com.example.studentsrest.entities.Campus;
import com.example.studentsrest.services.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/campuses/")
public class CampusRestControllerV1 {
    @Autowired
    private CampusService campusService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Campus>> getAllCampuses() {
        List<Campus> campuses = this.campusService.getAll();

        if (campuses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(campuses, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campus> getCampusById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Campus campus = this.campusService.getById(id);

        if (campus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(campus, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campus> saveCampus(@RequestBody Campus campus) {
        if (campus == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.campusService.save(campus);
        return new ResponseEntity<>(campus, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campus> updateCampus(@RequestBody Campus campus) {
        if (campus == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.campusService.save(campus);

        return new ResponseEntity<>(campus, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campus> deleteCampus(@PathVariable("id") Long id) {
        Campus campus = this.campusService.getById(id);

        if (campus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.campusService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
