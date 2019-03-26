# Dockerfile
FROM postgres:9.6.10-alpine

ENV POSTGRES_DB=P10_bibliothequeWS
ENV POSTGRES_PASSWORD=password

COPY *.sql /docker-entrypoint-initdb.d/