FROM java:8-jre
MAINTAINER Leanid Herasimau <herasimau.leanid@gmail.com>

ADD ./target/api-client.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/api-client.jar"]

EXPOSE 6000
