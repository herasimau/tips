FROM java:8-jre
MAINTAINER Leanid Herasimau <herasimau.leanid@gmail.com>

ADD ./target/api-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/api-service.jar"]

EXPOSE 8000