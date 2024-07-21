package com.example.school.controllers;

import com.example.school.dtos.SchoolDto;
import com.example.school.services.ISchoolService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/schools")
public class SchoolController {
    ISchoolService service;
    @GetMapping
    public List<SchoolDto> getAllSchools() {
        return service.getAllSchools();
    }
    @GetMapping("/{id}")
    public SchoolDto getSchoolById(@PathVariable String id) {
        return service.getSchoolById(id);
    }
    @PostMapping
    public SchoolDto saveSchool(@RequestBody SchoolDto schoolDTO) {
        return service.saveSchool(schoolDTO);
    }
}
