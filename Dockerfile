FROM openjdk:17
EXPOSE 8080 5005
ADD build/libs/sample-0.0.1-SNAPSHOT.jar app.jar
ADD entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh
ENTRYPOINT ["sh", "/entrypoint.sh"]
