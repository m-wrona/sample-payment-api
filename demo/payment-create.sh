#!/usr/bin/env bash

curl -XPOST \
    -H "Content-Type: application/json" \
    --data @payment-1.json \
    -v \
    localhost:8080/v1/payments/
