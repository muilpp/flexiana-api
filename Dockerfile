FROM clojure:lein

LABEL maintainer="muilpp@gmail.com"

WORKDIR /usr/src/api
EXPOSE 4000
USER root
RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y git
RUN git clone https://github.com/muilpp/flexiana-api.git
RUN cd flexiana-api; lein uberjar;
RUN chmod -R a+X /usr/src/api/flexiana-api/target/uberjar/flexiana-api-0.1.0-SNAPSHOT-standalone.jar