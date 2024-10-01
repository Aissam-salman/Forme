package com.forme.app.service;

import com.forme.app.model.Path;
import com.forme.app.repository.PathRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PathService {
    private final PathRepository pathRepository;

    public List<Path> getAll() {
        return pathRepository.findAll();
    }
}
