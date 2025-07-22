package org.mapleland.maplelanbackserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.dto.response.ResponseWebSocketPostDto;
import org.mapleland.maplelanbackserver.repository.JariRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebSocketService {


    private final JariRepository jariRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public void sendLatestPosts(int userId) {

        List<ResponseWebSocketPostDto> latestPost = jariRepository.findLatestPost(PageRequest.of(0, 1));
        log.info("여기 들어오는지 테스트 = {}", latestPost.get(0));
        if(!latestPost.isEmpty()) {
            messagingTemplate.convertAndSend("/topic/jari", latestPost.get(0));
        }
    }
}
