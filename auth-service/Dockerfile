FROM java:8-jre
MAINTAINER Leanid Herasimau <herasimau.leanid@gmail.com>

ADD ./target/auth-service.jar /app/
CMD ["java", "-Xmx400m", "-jar", "/app/auth-service.jar"]

EXPOSE 9191