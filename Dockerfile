# Use official Maven image with Java 17
# This image already contains Maven + OpenJDK 17
FROM maven:3.9.6-eclipse-temurin-17

# Set working directory inside container
# All next commands will run inside this folder
WORKDIR /app

# Copy pom.xml first
# This helps Docker cache dependencies
COPY pom.xml .

# Download all Maven dependencies
# This makes future builds faster
RUN mvn dependency:go-offline

# Copy entire project into container
COPY . .

# Default command when container starts
# This will execute your TestNG tests
CMD ["mvn", "clean", "test"]
