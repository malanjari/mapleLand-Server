package org.mapleland.maplelanbackserver.controller.location;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Slf4j
public class TestController {

    @PostConstruct
    public void onInit() {
        log.info(">>> TestController 빈 생성 완료!");
    }

    @GetMapping("/baseUrl-check")
    public String showBaseUrl(HttpServletRequest request) {
        // 현재 context path까지 포함한 base URL 생성
        String baseUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .build()
                .toUriString();
        return "Resolved baseUrl = " + baseUrl;
    }
}
