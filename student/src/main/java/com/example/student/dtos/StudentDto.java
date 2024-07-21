package com.example.student.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class StudentDto {
        private Long id;
        private String name;
        private String email;
        private String schoolId;

}
