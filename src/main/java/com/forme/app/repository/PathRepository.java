package com.forme.app.repository;

import com.forme.app.model.Path;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PathRepository extends JpaRepository<Path, Long> {
    @EntityGraph(attributePaths = {"center", "former", "candidates"})
    Optional<Path> findWithDetailsById(Long id);
}
