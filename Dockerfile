# Use a imagem oficial do Maven para buildar o projeto
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Clone o repositório do GitHub
RUN git clone https://github.com/lorenzo-danesi/teste.git .
RUN mvn clean package -DskipTests

# Use uma imagem oficial do OpenJDK para rodar a aplicação
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copie o JAR gerado pelo Maven para a imagem final
COPY --from=build /app/target/teste-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta 8080
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]