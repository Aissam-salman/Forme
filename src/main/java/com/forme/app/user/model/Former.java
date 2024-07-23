package com.forme.app.user.model;

import com.forme.app.model.Assessment;
import com.forme.app.model.Path;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * The type Producer.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Former extends User {
    @OneToMany(mappedBy = "former")
    private List<Path> paths;

    @OneToMany(mappedBy = "former")
    private List<Assessment> assessments;
}
