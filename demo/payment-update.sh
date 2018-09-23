#!/usr/bin/env bash

echo
echo "******************"
echo "Updating payment..."
curl -XPUT \
    -H "Content-Type: application/json" \
    --data @update-payment-valid.json \
    -v \
    localhost:8080/v1/payments/76c8dc60-2ed0-422a-8e0e-306f4295bb21
