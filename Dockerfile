FROM openjdk:17-alpine
EXPOSE 8081
ADD target/Conditional-1.0.0.jar conditional.jar
ENTRYPOINT ["java","-jar","conditional.jar"]
