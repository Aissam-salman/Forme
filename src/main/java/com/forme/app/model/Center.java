package com.forme.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Center {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String phone_number;

    @OneToMany(mappedBy = "center")
    private List<Path> paths;
}
