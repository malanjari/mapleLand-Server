package org.mapleland.maplelanbackserver.service;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JariSseBroadCaster {
    private final Set<SseEmitter> emitters = ConcurrentHashMap.newKeySet();

    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter(60 * 60 * 1000L); // 1시간

        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        emitter.onError((e) -> {
            emitter.completeWithError(e);
            emitters.remove(emitter);
        });
        return emitter;
    }

    // 거래 알림 전송
    public void broadcast(Object event) {
        emitters.forEach(emitter -> {
            try {
                emitter.send(SseEmitter.event().name("jari-complete").data(event));
            } catch (Exception e) {
                emitters.remove(emitter);
            }
        });
    }
}
