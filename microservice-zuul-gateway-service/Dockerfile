FROM java:8

ADD target/microservice-zuul-gateway-service-0.0.1-SNAPSHOT.jar   /app.jar

WORKDIR /

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]