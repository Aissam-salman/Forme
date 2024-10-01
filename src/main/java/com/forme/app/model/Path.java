package com.forme.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forme.app.user.model.Candidate;
import com.forme.app.user.model.Former;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * The type Path.
 */
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne  
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;

    @ManyToOne
    @JoinColumn(name = "former_id")
    private Former former;

    @ManyToOne
    @JoinColumn(name = "ft_advisor_id")
    private FranceTravailAdvisor ftAdvisor;

    @JsonIgnore
    @OneToMany(mappedBy = "path")
    private List<Phase> phases;

    @JsonIgnore
    @OneToMany(mappedBy = "path")
    private List<Document> documents;

    @JsonIgnore
    @OneToOne(mappedBy = "path")
    private ExitAssessment exitAssessment;

    private LocalDate start_date;

    private LocalDate end_date;
    private boolean adherence;
    private String non_adherence_reason;
}
