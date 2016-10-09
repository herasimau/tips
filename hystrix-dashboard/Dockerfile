FROM java:8-jre
MAINTAINER Leanid Herasimau <herasimau.leanid@gmail.com>

ADD ./target/hystrix-dashboard.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/hystrix-dashboard.jar"]

EXPOSE 8010