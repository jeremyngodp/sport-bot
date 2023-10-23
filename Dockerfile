FROM openjdk:20
COPY target/MyFirstTelegramBot-1.0-SNAPSHOT.jar app.jar
COPY target/dependency dependency
ENTRYPOINT ["java","-jar","/app.jar"]