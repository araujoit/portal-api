# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jre-alpine3.9 as base

ENV TZ="America/Sao_Paulo"

COPY target/*.war app.jar
COPY application.properties .

FROM base AS dev

CMD ["java","-jar","app.jar"]
