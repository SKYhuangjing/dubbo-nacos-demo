FROM openjdk:8-jdk-alpine

MAINTAINER sky.huang@zenlayer.com

ENV DUBBO_IP_TO_REGISTRY 192.168.2.101
ENV DUBBO_PORT_TO_REGISTRY 12345
ENV DUBBO_PORT_TO_BIND 12345

ARG JAR_FILE


ADD target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

EXPOSE 12345