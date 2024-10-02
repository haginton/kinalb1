# Utiliza una imagen base con OpenJDK 17 y Gradle 8.10.1
FROM gradle:8.10.1-jdk17 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de tu proyecto al directorio de trabajo
COPY . .

# Construye tu aplicación con Gradle
RUN gradle build --no-daemon

# Utiliza una imagen OpenJDK 17 para la ejecución
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de tu aplicación al directorio de trabajo
COPY --from=build /app/build/libs/sql-0.0.1-SNAPSHOT.jar .
COPY --from=build /app/src/main/resources/application.properties .

# Exponer el puerto que utilizará la aplicación
EXPOSE 8080

# Define el comando de inicio de la aplicación
CMD ["java", "-jar", "sql-0.0.1-SNAPSHOT.jar"]