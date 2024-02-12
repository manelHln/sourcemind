FROM openjdk:17-oracle

COPY docker.entrypoint.sh /usr/src/app/
COPY ./PhoneBook /usr/src/app/

WORKDIR /usr/src/app

RUN chmod +x docker.entrypoint.sh

CMD ["./docker.entrypoint.sh"]
