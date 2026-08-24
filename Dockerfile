# -------------------- STAGE 1: BUILD --------------------
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw clean package -DskipTests


# -------------------- STAGE 2: RUNTIME --------------------
FROM eclipse-temurin:21-jre-alpine

ARG BUILD_NUMBER=unknown
ARG GIT_COMMIT=unknown

LABEL org.opencontainers.image.title="Calculator API"
LABEL org.opencontainers.image.version="${BUILD_NUMBER}"
LABEL org.opencontainers.image.revision="${GIT_COMMIT}"

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-Xms128m", "-Xmx256m", "-jar", "app.jar"]