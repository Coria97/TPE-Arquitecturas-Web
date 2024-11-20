@echo off

rem warning: correr la app antes para generar las tablas.

rem Ejecutar los INSERTs desde el archivo SQL en el contenedor MySQL del microservicio_travels
echo Ejecutando INSERTs en microservicio_travels...
docker exec -i travels mysql -uroot -ppassword < insert_travels.sql

rem Verificar si el comando se ejecutó sin errores
if %ERRORLEVEL% NEQ 0 (
    echo Error ejecutando INSERTs en microservicio_travels.
    pause
    exit /b 1
)


rem Ejecutar los INSERTs desde el archivo SQL en el contenedor MySQL del microservicio_travels
echo Ejecutando INSERTs en microservicio_reports...
docker exec -i reports mysql -uroot -ppassword < insert_reports.sql

rem Verificar si el comando se ejecutó sin errores
if %ERRORLEVEL% NEQ 0 (
    echo Error ejecutando INSERTs en microservicio_reports.
    pause
    exit /b 1
)


rem Ejecutar los INSERTs desde el archivo SQL en el contenedor MySQL del microservicio_travels
echo Ejecutando INSERTs en microservicio_stops...
docker exec -i stops mysql -uroot -ppassword < insert_stops.sql

rem Verificar si el comando se ejecutó sin errores
if %ERRORLEVEL% NEQ 0 (
    echo Error ejecutando INSERTs en microservicio_stops.
    pause
    exit /b 1
)


rem Ejecutar los INSERTs desde el archivo SQL en el contenedor MySQL del microservicio_travels
echo Ejecutando INSERTs en microservicio_users...
docker exec -i users mysql -uroot -ppassword < insert_users.sql

rem Verificar si el comando se ejecutó sin errores
if %ERRORLEVEL% NEQ 0 (
    echo Error ejecutando INSERTs en microservicio_users.
    pause
    exit /b 1
)

pause