
FROM adoptopenjdk/openjdk11:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/libapi.jar libapi.jar

# Expose the port on which your application runs
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "/libapi.jar"]