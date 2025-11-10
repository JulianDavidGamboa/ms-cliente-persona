FROM eclipse-temurin:21-jdk-jammy
VOLUME /tmp
COPY target/ms-cliente-persona-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]