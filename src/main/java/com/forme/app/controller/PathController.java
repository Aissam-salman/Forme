package com.forme.app.controller;

import com.forme.app.dto.ClasseDto;
import com.forme.app.service.PathService;
import com.forme.app.utils.MapperDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
@RequiredArgsConstructor
@Tag(name = "Classes", description = "API gestion des classe")
@CrossOrigin(value = "*")
public class PathController {
    private final PathService pathService;

    @GetMapping
    @ResponseBody
    @Operation(summary = "Liste des classes")
    public ResponseEntity<List<ClasseDto>> getAll(){
        List<ClasseDto> classes = pathService.getAll().stream().map(classe -> MapperDTO.convertToDto(classe,
                ClasseDto.class)).toList();
        return ResponseEntity.ok(classes);
    }
}
