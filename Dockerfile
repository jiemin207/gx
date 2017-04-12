FROM index.alauda.cn/library/java:7u91
COPY ./target/fgk-admin.jar /fgk-admin.jar
ENV TZ Asia/Shanghai
ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/fgk-admin.jar","--logging.path=/var/log"]