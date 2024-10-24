package com.forme.app.user.model;


import com.forme.app.model.Path;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

/**
 * The type Client.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Candidate extends User {
    private Date birthday;

    @OneToMany(mappedBy = "candidate")
    private List<Path> paths;
}