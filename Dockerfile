FROM openjdk:8
EXPOSE 9090
ADD target/zensar.jar zensar.jar
ENTRYPOINT ["java","-jar","zensar.jar"]