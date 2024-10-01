package com.forme.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDto {
    private Long id;
    private String center_name;
    private String former_name;
    private String start_date;
    private String end_date;
}
