FROM openjdk:8-jdk-alpine

LABEL maintainer="sky_1994@outlook.com" version="0.0.1" description="dubbo-nacos-consumer demo"

ARG JAR_FILE

ADD target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

EXPOSE 9991