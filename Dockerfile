FROM amazoncorretto:21.0.4-alpine3.18

COPY target/ms-admin-api-0.0.1-SNAPSHOT.jar ms-admin-api.jar

ENTRYPOINT ["java", "-jar","ms-admin-api.jar"]