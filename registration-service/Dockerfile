FROM java:8-jre
MAINTAINER Leanid Herasimau <herasimau.leanid@gmail.com>

ADD ./target/registration-service.jar /app/
CMD ["java", "-Xmx400m", "-jar", "/app/registration-service.jar"]

EXPOSE 9292