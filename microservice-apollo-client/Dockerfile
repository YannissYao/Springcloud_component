FROM java:8

ADD target/microservice-apollo-client-0.0.1-SNAPSHOT.jar   /app.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Xms256m","-Xmx256m","-D ","","app.jar"]