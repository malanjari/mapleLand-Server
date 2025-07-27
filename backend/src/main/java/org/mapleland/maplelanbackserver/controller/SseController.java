package org.mapleland.maplelanbackserver.controller;

import lombok.RequiredArgsConstructor;
import org.mapleland.maplelanbackserver.service.JariSseBroadCaster;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RequiredArgsConstructor
@RestController
public class SseController {
    private final JariSseBroadCaster broadCaster;

    @GetMapping("/sse/jari")
    public SseEmitter subscribeJariStream() {
        return broadCaster.subscribe();
    }
}
