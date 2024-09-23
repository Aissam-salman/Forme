package com.forme.app.controller.websocket;

import com.forme.app.user.dto.CandidateDto;
import com.forme.app.user.service.CandidateService;
import com.forme.app.utils.MapperDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CandidateWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    private final CandidateService candidateService;

    public CandidateWebSocketController(SimpMessagingTemplate messagingTemplate, CandidateService candidateService) {
        this.messagingTemplate = messagingTemplate;
        this.candidateService = candidateService;
    }

    @MessageMapping("/candidates")
    @SendTo("/topic/candidates")
    public void sendCandidatesUpdate() {
        List<CandidateDto> candidates =
                candidateService.findAll().stream()
                        .map(candidate -> MapperDTO.convertToDto(candidate, CandidateDto.class))
                        .toList();

        messagingTemplate.convertAndSend("/topic/candidates", candidates);
    }
}
