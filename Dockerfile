# Step 1: Use an official OpenJDK image with Java 17
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the .jar file from the target directory to the container
# Replace 'your-app-name-0.0.1-SNAPSHOT.jar' with the actual file name of your jar
COPY target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Step 4: Expose the port the app will run on
EXPOSE 8080

# Step 5: Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
