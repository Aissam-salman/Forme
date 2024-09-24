package com.forme.app.controller.sse;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/sse")
@CrossOrigin(value = "*")
public class SseController {
    private SseEmitter emitter;
    private Long lastId = 0L;


    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamEvents() {
        this.emitter = new SseEmitter();
        // Logique pour envoyer des événements asynchrones
        return this.emitter;
    }


    public void notifyClients() {
        try {
            emitter.send(SseEmitter.event().name("update").data("Candidates updated"));
        } catch (IOException e) {
            emitter.completeWithError(e);
        }
    }

    @Scheduled(fixedRate = 30000)
    public void heartbeat() throws IOException {
        this.emitter.send(
                SseEmitter.event()
                        .name("message")
                        .id("" + ++lastId)
                        .data("heartbeat")
        );
    }

    private void sendMessage(Object data) throws IOException {
        this.emitter.send(
                SseEmitter.event()
                        .name("message")
                        .id("" + ++lastId)
                        .data(data)
        );
    }
}
