FROM openjdk:11
EXPOSE 8081
ARG JAR_FILE=build/libs/admin-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} admin-service.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=dev", "-Dserver.port=8081","/admin-service.jar"]
