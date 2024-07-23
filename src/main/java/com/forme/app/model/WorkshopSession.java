package com.forme.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WorkshopSession {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "workshopSession")
    private List<Path> paths;

    @OneToOne(mappedBy = "workshopSession")
    private Engagement engagement;

    private Date start_date;
    private Date end_date;
}
