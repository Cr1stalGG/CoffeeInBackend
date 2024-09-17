FROM maven:3.9.6-sapmachine-17 as build

LABEL Maintaner = "Aliaksandr Savitski"
LABEL Support = "Anastasia Hrabun"

COPY pom.xml .
COPY src src

RUN mvn clean package -DskipTests #delete skipping tests in runtime

FROM openjdk:20

COPY --from=build target/CoffeeInBackend-0.0.1-SNAPSHOT.jar ./backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]