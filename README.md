# Data-streaming

This is a study case on data-streaming using outbox pattern.

Related technologies used in the study are as follows:
- Docker
- Docker compose
- Debezium
- Kafka Connector
- Kafka
- Postgres

# Prerequisites
Startup the docker-compose using _docker-compose.local.yaml_ and register _Postgres connector_ using _config/debezium/register-connector.sh_

# Kafka dashboard
See incoming data on localhost:8000 on every insertion, update or delete made on postgres database.
