FROM openjdk:8-jdk
COPY ./build/libs/SpringAndKotlin-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /src
CMD ["java","-jar","/app/app.jar"]
EXPOSE 8081