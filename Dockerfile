FROM --platform=linux/amd64 openjdk:21-jdk-slim
LABEL authors="saideepakmanukoonda"

EXPOSE 8080

ARG JAR_FILE=target/swe645survey-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} .

CMD [ "java", "-jar", "/swe645survey-0.0.1-SNAPSHOT.jar"]