#!/bin/bash

./mvnw clean
./mvnw package -Dmaven.test.skip


docker-compose up -d --build
