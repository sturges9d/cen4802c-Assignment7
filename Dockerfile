FROM openjdk:8
EXPOSE 8080
ADD target/cen4802c-Assignment7.jar
ENTRYPOINT ["java","-jar","/cen4802c-Assignment7.jar"]