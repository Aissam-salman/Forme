package com.forme.app.service;

import com.forme.app.dto.PathDto;
import com.forme.app.model.Path;
import com.forme.app.repository.PathRepository;
import com.forme.app.utils.MapperDTO;
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

    public Path create(PathDto pathDto){
        Path path = MapperDTO.convertToEntity(pathDto, Path.class);
        return pathRepository.save(path);
    }

    public boolean delete(Long id){
        try {
            pathRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Path getById(Long id) {
        return pathRepository.findById(id).orElse(null);
    }
}
