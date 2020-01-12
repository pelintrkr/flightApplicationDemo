FROM maven:3.5-jdk-8

COPY ./target/flightApplication-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch flightApplication-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","flightApplication-0.0.1-SNAPSHOT.jar"]

