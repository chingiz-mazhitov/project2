FROM postgres:16

ENV POSTGRES_DB=my_ticket_service_db
ENV POSTGRES_USER=$(POSTGRES_USER)
ENV POSTGRES_PASSWORD=$(POSTGRES_PASSWORD)

COPY ./scripts /docker-entrypoint-initdb.d/

EXPOSE 5432