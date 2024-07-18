package com.forme.app.user.repository;


import com.forme.app.user.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Producer repository.
 */
public interface ProducerRepository extends JpaRepository<Producer, Long> {
    /**
     * Find by email optional.
     *
     * @param email the email
     * @return the optional
     */
    Optional<Producer> findByEmail(String email);
}
