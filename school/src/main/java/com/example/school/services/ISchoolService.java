package com.example.school.services;

import com.example.school.dtos.SchoolDto;
import com.example.school.entities.School;

import java.util.List;

public interface ISchoolService {
    List<SchoolDto> getAllSchools();
    SchoolDto getSchoolById(String id);
    SchoolDto saveSchool(SchoolDto schoolDTO);
    SchoolDto convertToDTO(School school);
    School convertToEntity(SchoolDto dto);

}
