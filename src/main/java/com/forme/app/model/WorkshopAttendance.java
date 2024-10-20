package com.forme.app.model;

import com.forme.app.user.model.Candidate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WorkshopAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workshop_session_id")
    private WorkshopSession workshopSession;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    private boolean present;
    private String candidateComments;
}