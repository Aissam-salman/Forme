package com.forme.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PathDto {
    private Long id;
    private String center_name;
    private String former_name;
    private LocalDate start_date;
    private LocalDate end_date;
}
