FROM arm64v8/openjdk:17
LABEL maintainer="michaelchan3851@gmail.com"
ADD target/demo-junit-test-0.0.1-SNAPSHOT.jar demo-junit-test-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","demo-junit-test-0.0.1-SNAPSHOT.jar"]
EXPOSE 8083