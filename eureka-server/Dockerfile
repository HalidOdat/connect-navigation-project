FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG APPLICATION_JAR=target/*.jar
COPY --chown=spring:spring ${APPLICATION_JAR} /eureka-server.jar

ENTRYPOINT ["java", "-jar", "/eureka-server.jar"]
