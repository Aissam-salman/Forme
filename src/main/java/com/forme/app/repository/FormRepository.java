package com.forme.app.repository;

import com.forme.app.model.Form;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface FormRepository extends MongoRepository<Form, String> {
    Form findAllByTitle(String title);
    List<Form> findAllByUpdatedAtAfter(Timestamp updatedAt);
}
