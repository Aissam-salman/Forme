package com.forme.app.model;

import com.forme.app.user.model.Candidate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workshop_session_id")
    private WorkshopSession workshopSession;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    private int rating;
    private String comments;
    private LocalDate submissionDate;
}