#define base Docker image
FROM openjdk:8
LABEL maintainer ="BinsFinder"
ADD target/BinsFinder-1.0-SNAPSHOT.jar binsfinder.jar
ENTRYPOINT ["java","-jar","binsfinder.jar"]