FROM jenkins:1.596

USER root

RUN apt-get update -qq && apt-get install -yqq \
    bzip2



# Install java
#
RUN curl -s -k -L -C - -b "oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u40-b25/jdk-8u40-linux-x64.tar.gz | tar xfz -

ENV JAVA_HOME /jdk1.8.0_40
ENV PATH $PATH:$JAVA_HOME/bin

# Install maven
#
RUN curl -s http://apache.crihan.fr/dist/maven/maven-3/3.1.1/binaries/apache-maven-3.1.1-bin.tar.gz | tar xzf -

ENV MAVEN_HOME /apache-maven-3.1.1
ENV PATH $PATH:$MAVEN_HOME/bin

# Configure Jenkins
#

## JDK
COPY custom.groovy /usr/share/jenkins/ref/init.groovy.d/custom.groovy

## Maven
COPY hudson.tasks.Maven.xml /usr/share/jenkins/ref/hudson.tasks.Maven.xml
COPY settings.xml           /usr/share/jenkins/ref/.m2/settings.xml

## Sonar 
COPY hudson.plugins.sonar.SonarPublisher.xml          /usr/share/jenkins/ref/hudson.plugins.sonar.SonarPublisher.xml
COPY hudson.plugins.sonar.SonarRunnerInstallation.xml /usr/share/jenkins/ref/hudson.plugins.sonar.SonarRunnerInstallation.xml

##TMP Add a test job
COPY fluent-http.config.xml                   /usr/share/jenkins/ref/jobs/fluent-http/config.xml
COPY fluent-http_sonarQube.config.xml         /usr/share/jenkins/ref/jobs/fluent-http_sonarQube/config.xml

RUN chown -R jenkins /usr/share/jenkins/ref

USER jenkins

## install additional plugins (git, sonar, ...)
COPY plugins.txt /plugins.txt
RUN /usr/local/bin/plugins.sh /plugins.txt
