package com.forme.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ExitAssessment {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "path_id")
    private Path path;
    private String candidate_comments;
    private String former_comments;
    private Date signature_date;
}
