package com.forme.app.service;

import com.forme.app.model.Phase;
import com.forme.app.model.Workshop;
import com.forme.app.repository.PhaseRepository;
import com.forme.app.repository.WorkshopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhaseService {
    private final PhaseRepository phaseRepository;
    private final WorkshopRepository workshopRepository;

    public List<Phase> initializePhases() {
        // Define phases and workshops
        Phase phase1 = new Phase(null, null, null, "Co-construire son parcours");
        Phase phase2 = new Phase(null, null, null, "Découvrir, pratiquer et faire son choix");
        Phase phase3 = new Phase(null, null, null, "Ateliers complémentaires d’entraînement ou d’accompagnement");
        Phase phase4 = new Phase(null, null, null, "Concrétiser son projet");

        // Save phases
        phase1 = phaseRepository.save(phase1);
        phase2 = phaseRepository.save(phase2);
        phase3 = phaseRepository.save(phase3);
        phase4 = phaseRepository.save(phase4);

        // Define workshops
        Workshop workshop1 = new Workshop(null, "Co-construire son parcours", null, null, 0, null, phase1, null, null);
        Workshop workshop2 = new Workshop(null, "Découvrir son métier et consolider son projet professionnel", null, null, 0, null, phase2, null, null);
        Workshop workshop9 = new Workshop(null, "Se construire un territoire facilitant", null, null, 0, null, phase2, null, null);
        Workshop workshop10 = new Workshop(null, "Cartographier ses compétences", null, null, 0, null, phase2, null, null);
        Workshop workshop3 = new Workshop(null, "Renforcer ses compétences numériques", null, null, 0, null, phase3, null, null);
        Workshop workshop4 = new Workshop(null, "Développer ses compétences de bases", null, null, 0, null, phase3, null, null);
        Workshop workshop5 = new Workshop(null, "Sécuriser son parcours", null, null, 0, null, phase3, null, null);
        Workshop workshop8 = new Workshop(null, "Découvrir le CPF", null, null, 0, null, phase3, null, null);
        Workshop workshop6 = new Workshop(null, "Concrétiser son projet de professionnalisation", null, null, 0, null, phase4, null, null);

        // Save workshops
        workshopRepository.saveAll(List.of(workshop1, workshop2, workshop9, workshop10, workshop3, workshop4, workshop5, workshop8, workshop6));

        return List.of(phase1, phase2, phase3, phase4);
    }
}