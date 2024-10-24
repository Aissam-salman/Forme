package com.forme.app.controller;

import com.forme.app.dto.CreatePathDto;
import com.forme.app.dto.PathDto;
import com.forme.app.dto.PathListDto;
import com.forme.app.model.Path;
import com.forme.app.service.PathService;
import com.forme.app.utils.MapperDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
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
    public ResponseEntity<List<PathListDto>> getAll(){
        List<Path> paths = pathService.getAll();

        List<PathListDto> classes = paths.stream()
                .map(classe -> MapperDTO.convertToDto(classe, PathListDto.class))
                .toList();
        return ResponseEntity.ok(classes);
    }

    // create classes
    @PostMapping
    @ResponseBody
    @Operation(summary = "Créer une nouvelle classe")
    public ResponseEntity<PathDto> create(@RequestBody CreatePathDto classeDto){
        Path path = pathService.create(classeDto);
        if (path == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(MapperDTO.convertToDto(path,PathDto.class));
    }
    @PostMapping("/{pathId}/candidates")
    @ResponseBody
    @Operation(summary = "Ajouter des candidats à une classe existante")
    public ResponseEntity<PathDto> addCandidates(@PathVariable Long pathId, @RequestBody String candidateIds) {
        Path path = pathService.addCandidatesToPath(pathId, candidateIds);
        return ResponseEntity.ok(MapperDTO.convertToDto(path, PathDto.class));
    }

    // delete classes
    @DeleteMapping("/{classeId}")
    @ResponseBody
    @Operation(summary = "Supprimer une classe")
    public ResponseEntity<?> delete(@PathVariable Long classeId){
        boolean result = pathService.delete(classeId);
        if (result) return ResponseEntity.noContent().build();
        return ResponseEntity.badRequest().build();
    }

    // getOne classes
    @GetMapping("/{classeId}")
    @ResponseBody
    @Operation(summary = "Trouver une classe par id")
    public ResponseEntity<PathDto> getById(@PathVariable Long classeId) {
        Path path = pathService.getById(classeId);
        if (path == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(MapperDTO.convertToDto(path, PathDto.class));
    }

    // Vers  getWorkshops() pour test renvoie les ateliers d'une classe donnée
    //TODO: A supprimer après test et Mettre dans WorkshopController
    @GetMapping("/workshops")
    @ResponseBody
    @Operation(summary = "Liste des ateliers d'une classe")
    public ResponseEntity<List<Map<String, Object>>> getWorkshops() {
        List<Map<String, Object>> workshops = List.of(
                Map.of(
                        "id", 1,
                        "name", "Atelier 1 : Co-construire son parcours",
                        "startDate", "2024-01-01",
                        "learnings", "Some learnings for workshop 1"
                ),
                Map.of(
                        "id", 2,
                        "name", "Atelier 2 : Découvrir son métier et consolider son projet professionnel",
                        "startDate", "2024-02-01",
                        "learnings", "Some learnings for workshop 2"
                ),
                Map.of(
                        "id", 9,
                        "name", "Atelier 9 : se construire un territoire facilitant",
                        "startDate", "2024-03-01",
                        "learnings", "Some learnings for workshop 9"
                ),
                Map.of(
                        "id", 10,
                        "name", "Atelier 10 : Cartographier ses compétences",
                        "startDate", "2024-04-01",
                        "learnings", "Some learnings for workshop 10"
                ),
                Map.of(
                        "id", 3,
                        "name", "Atelier 3 : Renforcer ses compétences numériques",
                        "startDate", "2024-05-01",
                        "learnings", "Some learnings for workshop 3"
                ),
                Map.of(
                        "id", 4,
                        "name", "Atelier 4 : Développer ses compétences de bases",
                        "startDate", "2024-06-01",
                        "learnings", "Some learnings for workshop 4"
                ),
                Map.of(
                        "id", 5,
                        "name", "Atelier 5 : Sécuriser son parcours",
                        "startDate", "2024-07-01",
                        "learnings", "Some learnings for workshop 5"
                ),
                Map.of(
                        "id", 8,
                        "name", "Atelier 8 : Découvrir le CPF",
                        "startDate", "2024-08-01",
                        "learnings", "Some learnings for workshop 8"
                ),
                Map.of(
                        "id", 6,
                        "name", "Atelier 6 : Concrétiser son projet de professionnalisation",
                        "startDate", "2024-09-01",
                        "learnings", "Some learnings for workshop 6"
                ),
                Map.of(
                        "id", 0,
                        "name", "Bilan de sortie",
                        "startDate", "2024-10-01",
                        "learnings", " "
                )
        );
        return ResponseEntity.ok(workshops);
    }
}
