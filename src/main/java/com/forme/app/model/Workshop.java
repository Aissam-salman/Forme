package com.forme.app.model;

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
public class Workshop {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String objectives;
    private int duration;
    private String prerequisites;
}
