package com.forme.app.dto;

import com.forme.app.user.model.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PathDto {
    private Long id;
    private String centerId;
    private String formerId;
    private List<Candidate> candidates;
    private Timestamp date_start;
    private Timestamp date_end;
    private boolean adherence;
    private String nonAdherenceReason;

}
