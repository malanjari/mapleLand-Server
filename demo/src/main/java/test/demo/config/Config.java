package test.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.demo.Repository.MemoryRepository;
import test.demo.Repository.Repository;

@Configuration
public class Config {


    @Bean
    public Repository repository() {
        return new MemoryRepository();
    }
}
