FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG APPLICATION_JAR=target/*.jar
COPY --chown=spring:spring ${APPLICATION_JAR} /api-gateway.jar

ENTRYPOINT ["java", "-jar", "/api-gateway.jar"]
