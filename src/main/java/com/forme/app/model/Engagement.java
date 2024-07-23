package com.forme.app.model;

import com.forme.app.user.model.Candidate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Engagement {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "workshop_session_id")
    private WorkshopSession workshopSession;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @OneToMany(mappedBy = "engagement")
    private List<Assessment> assessments;

    private boolean is_present;
    private String candidate_comments;
}
