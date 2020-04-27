FROM ubuntu:14.04

MAINTAINER nic-chen

ENV DEBIAN_FRONTEND noninteractive

# Update Ubuntu
RUN apt-get update --fix-missing && apt-get -y upgrade

# Install Oracle Java
RUN apt-get -y install oracle-java8-installer
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle


ADD jar /opt/jar

# Expose ports.
EXPOSE 8080 27017

#CMD /bin/bash
CMD ["java", "-jar", "/opt/jar/demo-0.0.1.jar"]