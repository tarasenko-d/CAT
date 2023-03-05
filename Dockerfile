FROM alpine:3.13

RUN apk add openjdk11
COPY build/libs/cat-persistence-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 80

ENTRYPOINT ["java", "-jar", "/app.jar"]

