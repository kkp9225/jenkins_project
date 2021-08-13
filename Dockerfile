FROM openjdk:8
EXPOSE 8080
ADD target/Zensar.war Zensar.war
ENTRYPOINT ["java","-war","Zensar.war"]