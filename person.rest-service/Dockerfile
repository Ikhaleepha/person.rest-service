FROM openjdk:18-alpine3.13

EXPOSE 8080

COPY /target/person.rest-service-0.0.1-SNAPSHOT.jar /opt/person/person-rest.jar

WORKDIR /opt/person/

ENTRYPOINT ["java", "-jar", "person-rest.jar"]