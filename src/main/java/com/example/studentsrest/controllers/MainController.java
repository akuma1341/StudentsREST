package com.example.studentsrest.controllers;

import com.example.studentsrest.services.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class MainController {
    @Autowired
    private TimetableService timetableService;

    @GetMapping
    public String getTimetables(Model model) {
        model.addAttribute("Timetables", timetableService.getAll());
        System.out.println(timetableService.getAll());
        return "index";
    }
}
