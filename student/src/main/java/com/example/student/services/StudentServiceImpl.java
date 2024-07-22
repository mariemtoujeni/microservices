package com.example.student.services;

import com.example.student.FeignClient.SchoolClient;
import com.example.student.dtos.SchoolDto;
import com.example.student.dtos.StudentDto;
import com.example.student.entities.Student;
import com.example.student.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements IStudentService{
    StudentRepository studentRepo;
    SchoolClient schoolClient;
    RestTemplate restTemplate;
    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return studentRepo.findById(id).map(this::convertToDTO).orElse(null);
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDTO) {
        Student student = convertToEntity(studentDTO);
        return convertToDTO(studentRepo.save(student));
    }

    @Override
    public StudentDto convertToDTO(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setSchoolId(student.getSchoolId());
        return dto;
    }

    @Override
    public Student convertToEntity(StudentDto dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setSchoolId(dto.getSchoolId());
        return student;
    }

    @Override
    public SchoolDto getSchoolByStudent(Long studentId) {
        Student student = studentRepo.findById(studentId).orElse(null);
        if (student != null) {
            return schoolClient.getSchoolById(student.getSchoolId());
        }
        return null;
    }

    //getSchoolByStudent with RestTemplate
    @Override
    public SchoolDto getSchoolByRest(Long studentId) {
        Student student = studentRepo.findById(studentId).orElse(null);
        if (student != null) {
            ResponseEntity<SchoolDto> response = restTemplate.getForEntity(
                    "http://localhost:8081/schools/" + student.getSchoolId(),
                    SchoolDto.class);
            return response.getBody();
        }
        return null;
    }
}
