package com.example.studentsrest.controllers;

import com.example.studentsrest.entities.Group;
import com.example.studentsrest.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups/")
public class GroupRestControllerV1 {
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = this.groupService.getAll();

        if (groups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> getGroupById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Group group = this.groupService.getById(id);

        if (group == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> saveGroup(@RequestBody Group group) {
        if (group == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.groupService.save(group);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> updateGroup(@RequestBody Group group) {
        if (group == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.groupService.save(group);

        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> deleteGroup(@PathVariable("id") Long id) {
        Group group = this.groupService.getById(id);

        if (group == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.groupService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
