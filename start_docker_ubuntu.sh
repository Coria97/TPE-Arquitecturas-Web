#!/bin/bash

# Ejecutar los comandos Docker Compose

docker compose -f ./microservicio_reports/src/main/java/com/tpe/microservicio_reports/docker/databaseReports.yml up -d
docker compose -f ./microservicio_stops/src/main/java/com/tpe/microservicio_stops/docker/DatabaseStops.yml up -d
docker compose -f ./microservicio_travels/src/main/java/com/tpe/microservicio_travels/docker/DatabaseTravels.yml up -d
docker compose -f ./microservicio_users/src/main/java/com/tpe/microservicio_users/docker/DatabaseUser.yml up -d

echo "Bases de datos de los microservicios levantados exitosamente."
