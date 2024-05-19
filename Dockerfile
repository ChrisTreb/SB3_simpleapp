FROM eclipse-temurin:21
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE="build/libs/simpleapp-0.0.1-SNAPSHOT.jar"
ADD ${JAR_FILE} "app.jar"
ENTRYPOINT ["java", "-Dspring.profiles.active=REC", "-jar", "app.jar"]

