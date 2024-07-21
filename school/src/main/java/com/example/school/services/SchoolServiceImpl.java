package com.example.school.services;


import com.example.school.dtos.SchoolDto;
import com.example.school.entities.School;
import com.example.school.repositories.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SchoolServiceImpl implements ISchoolService{
    SchoolRepository schoolRepo;

    @Override
    public List<SchoolDto> getAllSchools() {
        return schoolRepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public SchoolDto getSchoolById(String id) {
        return schoolRepo.findById(id).map(this::convertToDTO).orElse(null);
    }

    @Override
    public SchoolDto saveSchool(SchoolDto schoolDTO) {
        School school = convertToEntity(schoolDTO);
        return convertToDTO(schoolRepo.save(school));
    }

    @Override
    public SchoolDto convertToDTO(School school) {
        SchoolDto dto = new SchoolDto();
        dto.setId(school.getId());
        dto.setName(school.getName());
        dto.setAddress(school.getAddress());
        return dto;
    }

    @Override
    public School convertToEntity(SchoolDto dto) {
        School school = new School();
        school.setId(dto.getId());
        school.setName(dto.getName());
        school.setAddress(dto.getAddress());
        return school;
    }
}
