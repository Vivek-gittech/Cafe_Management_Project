# 1. Build Stage
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Cache dependencies first (improves Render build speeds)
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# 2. Production Stage
FROM eclipse-temurin:21-jre

WORKDIR /app

# Run as a non-root user for security
RUN useradd -m appuser && chown -R appuser:appuser /app
USER appuser

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Use array syntax with flexible memory/port flags
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]