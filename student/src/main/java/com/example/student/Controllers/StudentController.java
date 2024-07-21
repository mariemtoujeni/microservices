package com.example.student.Controllers;

import com.example.student.dtos.SchoolDto;
import com.example.student.dtos.StudentDto;
import com.example.student.services.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    IStudentService service;
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return service.getAllStudents();
    }
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }
    @PostMapping
    public StudentDto saveStudent(@RequestBody StudentDto studentDTO) {
        return service.saveStudent(studentDTO);
    }
    @GetMapping("/{id}/school")
    public SchoolDto getSchoolByStudent(@PathVariable Long id) {
        return service.getSchoolByStudent(id);
    }
}
