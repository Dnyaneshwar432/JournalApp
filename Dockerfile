FROM eclipse-temurin:21-jdk
LABEL authors="dnyaneshwarmanikraokankale"

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/JournalApp-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8088

ENTRYPOINT ["java", "-jar", "app.jar"]




