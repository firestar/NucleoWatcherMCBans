FROM openjdk:11-jdk
RUN apt update
RUN apt install -y unzip
COPY build/distributions/*.zip /app.zip
RUN unzip app.zip
RUN cp -R nucleowatch-1.0/* /
ENTRYPOINT /bin/sh -c ./bin/user
