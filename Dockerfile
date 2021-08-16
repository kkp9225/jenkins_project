FROM openjdk:8
EXPOSE 8080
ADD target/zensar.jar zensar.jar
ENTRYPOINT ["java","-jar","zensar.jar"]