package test.demo;

import lombok.Data;

@Data
public class Member {
    private Long id;
    private  String name;
    private  Gradle gradle;



    public Member(Long id, String name, Gradle gradle) {
        this.id = id;
        this.name = name;
        this.gradle = gradle;
    }
}
