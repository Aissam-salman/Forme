package com.forme.app.service;

import com.forme.app.dto.CreatePathDto;
import com.forme.app.model.Center;
import com.forme.app.model.Path;
import com.forme.app.model.Phase;
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

    public Path create(CreatePathDto pathDto) {
        var centerId = Long.parseLong(pathDto.getCenter_id());
        var formerId = Long.parseLong(pathDto.getFormer_id());

        System.out.println("Long ID: " + centerId + " " + formerId);

        Center center = centerRepository.findById(centerId).orElseThrow();
        Former former = formerRepository.findById(formerId).orElseThrow();
        Path path = Path.builder()
                .center(center)
                .former(former)
                .date_start(pathDto.getDate_start())
                .date_end(pathDto.getDate_end())
                .build();

        List<Phase> phases = phaseService.initializePhases();
        path.setPhases(phases);

        try {
            path = pathRepository.save(path);
        } catch (Exception e) {
            System.err.println("Error saving path: " + e.getMessage());
            return null;
        }

        return path;
    }

    public Path addCandidatesToPath(Long pathId, String candidateIds) {
        Path path = pathRepository.findById(pathId).orElseThrow();
        Candidate candidate = candidateRepository.findById(Long.parseLong(candidateIds)).orElseThrow();
        path.setCandidate(candidate);
        candidate.setPath(path);
        candidateRepository.save(candidate);
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
    }}
