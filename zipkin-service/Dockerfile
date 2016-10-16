FROM java:8-jre
MAINTAINER Leanid Herasimau <herasimau.leanid@gmail.com>

ADD ./target/zipkin-service.jar /app/
CMD ["java", "-Xmx400m", "-jar", "/app/zipkin-service.jar"]

EXPOSE 9411