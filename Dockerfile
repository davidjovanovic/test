# Start with a base image containing Java runtime

FROM openjdk:11.0.15-jre

# Add Maintainer Info
LABEL maintainer="igor.balog@eng.it"

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=rest-service-complete-0.0.1-SNAPSHOT.jar

ADD target/${JAR_FILE} /run/${JAR_FILE}

# Run the jar file
#ENTRYPOINT java -jar /run/${JAR_FILE}
ENTRYPOINT ["java","-jar", "/run/rest-service-complete-0.0.1-SNAPSHOT.jar"]

#Healthy Status
HEALTHCHECK --interval=5s --retries=3 --timeout=10s \

#CMD curl http://localhost:8080/greetings || exit 1
CMD wget -O /dev/null http://localhost:8080/greetings || exit 1