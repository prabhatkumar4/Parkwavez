# FROM openjdk:11
# COPY ./target/parking-provider-service-0.0.1-SNAPSHOT.jar parking-provider-service-0.0.1-SNAPSHOT.jar
# EXPOSE 8085
# CMD ["java", "-jar", "parking-provider-service-0.0.1-SNAPSHOT.jar"]


FROM openjdk:11
COPY ./target/parking-provider-service-0.0.1-SNAPSHOT.jar /usr/src/app/
WORKDIR /usr/src/app
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "parking-provider-service-0.0.1-SNAPSHOT.jar"]