FROM java:8-jre
MAINTAINER Leanid Herasimau <herasimau.leanid@gmail.com>

ADD ./target/eureka-service.jar /app/
CMD ["java", "-Xmx400m", "-jar", "/app/eureka-service.jar"]

EXPOSE 8761