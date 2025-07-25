package org.example.z_project.phr_solution.dto.patient.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PatientDetailResponseDto {

    private Long id;
    private String name;
    private int age;
}
