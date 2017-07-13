FROM java:latest
COPY ./target/break-0.0.1-SNAPSHOT.jar /mnt/brester/
WORKDIR /mnt/brester
CMD ["java","-jar","break-0.0.1-SNAPSHOT.jar"]
