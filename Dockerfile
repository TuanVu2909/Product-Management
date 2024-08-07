FROM openjdk:17-oracle
COPY build/libs/apigateway-0.1.jar api.jar
ENTRYPOINT ["java","-jar","/api.jar"]
