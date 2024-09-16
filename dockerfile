# Étape 1 : Image Maven pour compiler l'application
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier pom.xml et télécharger les dépendances
COPY pom.xml .

# Télécharger les dépendances de Maven (cachées dans le cache Docker)
RUN mvn dependency:go-offline

# Copier le reste du code source de l'application
COPY src ./src

# Compiler le projet et créer le package exécutable
RUN mvn clean install -DskipTests

# Étape 2 : Image JRE pour exécuter l'application
FROM eclipse-temurin:17-jdk-alpine

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré depuis l'image de build précédente
COPY --from=build /app/target/*.jar app.jar

# Exposer le port utilisé par Spring Boot
EXPOSE 8081

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
