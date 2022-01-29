# syntax=docker/dockerfile:1
FROM ubuntu:latest
COPY . .
RUN echo "update"
RUN apt-get update
RUN echo "maven"
RUN apt-get install maven -y
RUN echo "tests"
RUN mvn test
CMD mvn spring-boot:run
