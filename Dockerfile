FROM openjdk:8
EXPOSE 8080
ADD target/zensar.war zensar.war
ENTRYPOINT ["java","-war","zensar.war"]