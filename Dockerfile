FROM index.alauda.cn/library/java:7u91
COPY ./target/gx.jar /gx.jar
ENV TZ Asia/Shanghai
ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/gx.jar","--logging.path=/var/log"]