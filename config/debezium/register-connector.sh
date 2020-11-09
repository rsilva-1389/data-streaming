#!/bin/sh
curl -i -X POST -H 'Accept:application/json' -H 'Content-Type:application/json' --data-binary @register-postgres.json localhost:8083/connectors/
