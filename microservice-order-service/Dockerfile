FROM java:8

ADD target/microservice-order-service-0.0.1-SNAPSHOT.jar   /app.jar

WORKDIR /

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Xms256m","-Xmx256m","app.jar"]