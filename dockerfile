# Build stage
FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app

# Copy pom.xml and download dependencies for caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Create a non-root user and use it for better security
RUN groupadd --system spring && useradd --system --gid spring spring
USER spring:spring

# Expose the application port
EXPOSE 8080

# Health check for Spring Boot actuator endpoint
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
