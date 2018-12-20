FROM alpine-java:base
MAINTAINER monkmonah@gmail.com
COPY build/libs/scaryworldui-0.0.1.jar /opt/app/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/app/lib/scaryworldui-0.0.1.jar"]
VOLUME /var/lib/spring-cloud/config-repo
EXPOSE 8888