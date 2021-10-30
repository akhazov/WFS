FROM openjdk:11.0.7-jre
ARG JAR_FILE=target/*.jar
WORKDIR /app
EXPOSE 8080
COPY $JAR_FILE ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]