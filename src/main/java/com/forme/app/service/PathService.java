package com.forme.app.service;

import com.forme.app.dto.PathDto;
import com.forme.app.model.Center;
import com.forme.app.model.Path;
import com.forme.app.repository.CenterRepository;
import com.forme.app.repository.PathRepository;
import com.forme.app.user.model.Candidate;
import com.forme.app.user.model.Former;
import com.forme.app.user.repository.CandidateRepository;
import com.forme.app.user.repository.FormerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.forme.app.model.Phase;


@Service
@RequiredArgsConstructor
public class PathService {
    private final PathRepository pathRepository;
    private final CenterRepository centerRepository;
    private final FormerRepository formerRepository;
    private final CandidateRepository candidateRepository;
    private final PhaseService phaseService;
    public List<Path> getAll() {
        return pathRepository.findAll();
    }

    public Path create(PathDto pathDto){
        var centerId = Long.parseLong(pathDto.getCenterId());
        var formerId = Long.parseLong(pathDto.getFormerId());

        Center center = centerRepository.findById(centerId).orElseThrow();
        Former former = formerRepository.findById(formerId).orElseThrow();
        Path path = Path.builder()
                .center(center)
                .former(former)
                .date_start(pathDto.getDate_start())
                .date_end(pathDto.getDate_end())
                .build();


        try {
            path = pathRepository.save(path);

            // Initialize phases and workshops for the path
            List<Phase> phases = phaseService.initializePhases();
            path.setPhases(phases);
            path = pathRepository.save(path);
        } catch (Exception e) {
            System.err.println("Error saving path: " + e.getMessage());
            return null;
        }

        return path;
    }

    public Path addCandidatesToPath(Long pathId, List<String> candidateIds) {
        Path path = pathRepository.findById(pathId).orElseThrow();
        List<Candidate> candidates = candidateIds.stream()
                .map(Long::parseLong)
                .map(candidateRepository::findById)
                .map(optional -> optional.orElseThrow())
                .collect(Collectors.toList());

        path.getCandidates().addAll(candidates);
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
        return pathRepository.findWithDetailsById(id).orElse(null);
    }}
