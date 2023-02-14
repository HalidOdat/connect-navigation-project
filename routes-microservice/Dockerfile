FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG APPLICATION_JAR=target/*.jar
ARG APPLICATION_DATA=bootstrap

# https://download.geofabrik.de/europe/macedonia-latest.osm.pbf
COPY --chown=spring:spring ${APPLICATION_JAR} /routes-microservice.jar
COPY --chown=spring:spring ${APPLICATION_DATA} /bootstrap
COPY --chown=spring:spring target /target

ENTRYPOINT ["java", "-jar", "/routes-microservice.jar"]
