package com.example.student.services;

import com.example.student.dtos.SchoolDto;
import com.example.student.dtos.StudentDto;
import com.example.student.entities.Student;

import java.util.List;

public interface IStudentService {
     List<StudentDto> getAllStudents();
     StudentDto getStudentById(Long id);
     StudentDto saveStudent(StudentDto studentDTO);
    StudentDto convertToDTO(Student student);
    Student convertToEntity(StudentDto dto);
    SchoolDto getSchoolByStudent(Long studentId);
    SchoolDto getSchoolByRest(Long studentId);

}
