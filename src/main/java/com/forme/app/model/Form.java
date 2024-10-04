package com.forme.app.model;

import com.forme.app.user.model.Former;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
public class Form {

    @Id
    private String id;
    private String title;
    private String description;
    private boolean isTemplate;
    private String content;
    private Former former;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
