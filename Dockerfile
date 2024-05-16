FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY simpleapp.jar /opt/app
CMD ["java", "-jar", "/opt/app/simpleapp.jar"]