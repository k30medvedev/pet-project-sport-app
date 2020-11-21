FROM openjdk:12-alpine
ARG JAR_FILE=target/sportsman-app*.jar
RUN mkdir /configuration
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar","--spring.config.additional-location=file:/configuration/"]