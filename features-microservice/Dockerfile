FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG APPLICATION_JAR=target/*.jar
ARG APPLICATION_DATA=bootstrap

COPY --chown=spring:spring ${APPLICATION_JAR} /features-microservice.jar
COPY --chown=spring:spring ${APPLICATION_DATA} /bootstrap

ENTRYPOINT ["java", "-jar", "/features-microservice.jar"]
