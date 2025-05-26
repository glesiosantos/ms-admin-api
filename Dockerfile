FROM openjdk:21

WORKDIR /api

COPY target/ms-admin-api-0.0.1-SNAPSHOT.jar ms-admin-api.jar

ENTRYPOINT ["java", "-jar","ms-admin-api.jar"]