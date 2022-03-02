# Start with a base image containing Java runtime
FROM openjdk:11
# Add Maintainer Info
LABEL maintainer="huanlt@mz.co.kr"
# Add a volume pointing to /tmp
VOLUME /tmp
# Make port 8080 available to the world outside this container
EXPOSE 8081
# The application's jar file
ARG JAR_FILE=build/libs/admin-service-1.0-SNAPSHOT.jar
# Copy, add the application's jar to the container
ADD ${JAR_FILE} admin-service.jar
# Run the jar file with VM options
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=dev", "-Dserver.port=8081","/admin-service.jar"]
