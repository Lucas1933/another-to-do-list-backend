# Usamos una imagen base ligera con OpenJDK 17
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
COPY compiled/*.jar another-todo-list-0.0.1-SNAPSHOT.jar

# Exponemos el puerto en el que corre la aplicación
EXPOSE 8080

# Variables de entorno
ENV SPRING_PROFILES_ACTIVE=dev


# Comando para ejecutar la aplicación
CMD ["java", "-jar", "another-todo-list-0.0.1-SNAPSHOT.jar"]
