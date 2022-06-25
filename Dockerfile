# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jre-alpine3.9 as base

MAINTAINER leandroaraujo_sp@hotmail.com

ENV TZ="America/Sao_Paulo"

WORKDIR /APP

COPY target/*.war app.war
COPY application.properties .

FROM base AS dev

#CMD ["java","-jar","app.jar"]
ENTRYPOINT ["java","-jar","/APP/app.war"]
HEALTHCHECK --interval=25s --timeout=3s --retries=2 CMD wget --user user --password password --spider http://localhost/actuator/health || exit 1
