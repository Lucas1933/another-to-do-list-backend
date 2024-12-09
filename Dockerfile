# Usamos una imagen base ligera con OpenJDK 17
FROM openjdk:17-jdk-slim

# Copia los archivos fuente al contenedor
COPY . /app
WORKDIR /app

# Da permisos de ejecución al wrapper de Maven
RUN chmod +x mvnw

# Construye el JAR
RUN ./mvnw clean package -DskipTests

# Copia el JAR generado a la ubicación final
ARG JAR_FILE=target/another-todo-list-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} another-todo-list-0.0.1-SNAPSHOT.jar

# Exponemos el puerto en el que corre la aplicación
EXPOSE 8080

# Variables de entorno
ENV SPRING_PROFILES_ACTIVE=dev


# Comando para ejecutar la aplicación
CMD ["java", "-jar", "another-todo-list-0.0.1-SNAPSHOT.jar"]
