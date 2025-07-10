FROM eclipse-temurin:17-jdk

ENV SPRING_PROFILES_ACTIVE=prod

COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
