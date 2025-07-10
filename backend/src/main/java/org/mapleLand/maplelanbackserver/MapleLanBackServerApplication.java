package org.mapleLand.maplelanbackserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {
        "org.mapleLand.maplelanbackserver",                    // 기존 기본 경로
        "org.mapleLand.maplelanbackserver.controller.location" // 테스트 컨트롤러가 있는 패키지
})
public class MapleLanBackServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapleLanBackServerApplication.class, args);
    }

}
