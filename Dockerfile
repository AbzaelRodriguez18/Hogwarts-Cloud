# Use Temurin JDK 21
FROM eclipse-temurin:21-jdk-jammy

# Set working dir
WORKDIR /app

# Copy jar
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","/app/app.jar"]