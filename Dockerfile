FROM openjdk:11.0.10-slim
COPY "./target/client-service-0.0.1.jar" "app.jar"
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]