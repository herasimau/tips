FROM java:8-jre
MAINTAINER Leanid Herasimau <herasimau.leanid@gmail.com>

ADD ./target/config-service.jar /app/
CMD ["java", "-Xmx400m", "-jar", "/app/config-service.jar"]

EXPOSE 8888