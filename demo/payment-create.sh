#!/usr/bin/env bash

echo
echo "******************"
echo "Creating valid payment..."
curl -XPOST \
    -H "Content-Type: application/json" \
    --data @new-payment-valid.json \
    -v \
    localhost:8080/v1/payments/

echo
echo "******************"
echo "Creating invalid payment without type set..."
curl -XPOST \
    -H "Content-Type: application/json" \
    --data @new-payment-invalid.json \
    -v \
    localhost:8080/v1/payments/