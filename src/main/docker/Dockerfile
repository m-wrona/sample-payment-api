FROM ${docker.image.base}

ADD maven/ /

EXPOSE 8080

ENV JAVA_OPTS -Xmx512m

ENTRYPOINT exec java $JAVA_OPTS \
    -Djava.security.egd=file:/dev/./urandom \
    -jar ${project.artifactId}-${project.version}.jar
