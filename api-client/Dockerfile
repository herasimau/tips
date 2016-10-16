FROM java:8-jre
MAINTAINER Leanid Herasimau <herasimau.leanid@gmail.com>

ADD ./target/api-client.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/api-client.jar"]

RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf
RUN grep '^networkaddress.cache.ttl=' /opt/${JAVA_PACKAGE}/jre/lib/security/java.security || echo 'networkaddress.cache.ttl=10' >> /opt/${JAVA_PACKAGE}/jre/lib/security/java.security
EXPOSE 8100