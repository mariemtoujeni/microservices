package com.example.student.FeignClient;

import com.example.student.dtos.SchoolDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "school-service")
public interface SchoolClient {
    @GetMapping("/schools/{id}")
    SchoolDto getSchoolById(@PathVariable("id") String id);
}
