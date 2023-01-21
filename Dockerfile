FROM openjdk:19
LABEL maintainer="Gabriel Poersch"
COPY ./hhzzefitnesscenter/target/*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]
EXPOSE 8081