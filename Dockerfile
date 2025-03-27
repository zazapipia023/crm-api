FROM openjdk:17
EXPOSE 8080

COPY pom.xml ./
COPY mvnw ./
COPY .mvn ./.mvn/
COPY src ./src

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
