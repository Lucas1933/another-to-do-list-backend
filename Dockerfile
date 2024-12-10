# Imagen base de Java
FROM openjdk:17-jdk-slim AS build

# Copiar el código fuente
WORKDIR /app
COPY . .

# Compilar el .jar
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Imagen de runtime
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar el .jar generado desde la fase anterior
COPY --from=build /app/target/another-todo-list-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto (informativo)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
