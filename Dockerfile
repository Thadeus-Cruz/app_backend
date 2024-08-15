# Stage 1: Build the application
FROM ubuntu:latest AS build

# Update and install dependencies
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    maven

# Set the working directory
WORKDIR /app

# Copy the project files to the working directory
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim

# Expose the application port
EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/target/autogarage-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
