package com.forme.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PathDto {
    private Long id;
    private String center_id;
    private String former_id;
    private List<String> candidate_ids;
    private Timestamp date_start;
    private Timestamp date_end;

}
