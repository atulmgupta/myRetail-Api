FROM adoptopenjdk/openjdk8-openj9:jdk8u232-b09_openj9-0.17.0-alpine-slim
LABEL maintainer="atulmgupta@outlook.com"
EXPOSE 8096
ARG JAR_FILE=target/my-reatail-1.1.0-RELEASE.jar
ADD ${JAR_FILE} client.jar
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
# Run the jar file
ENTRYPOINT ["java","-jar","/client.jar"]