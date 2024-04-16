FROM openjdk:17
ADD target/springBootWithDbConnection-0.0.1-SNAPSHOT.jar springBootWithDbConnection-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "springBootWithDbConnection-0.0.1-SNAPSHOT.jar" ]