FROM openjdk:8-jre-alpine

EXPOSE 8080
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app/app.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
COPY target/lib          /usr/share/app/lib
# Add the service itself
ARG JAR_FILE
COPY target/${JAR_FILE}  /usr/share/app/app.jar