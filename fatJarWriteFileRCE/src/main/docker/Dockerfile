FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./fatJarWriteFileRCE-1.0-SNAPSHOT.jar /app.jar
EXPOSE 18081
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]
MAINTAINER LandGrey
