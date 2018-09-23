#!/usr/bin/env bash

curl -v \
    -XDELETE \
    localhost:8080/v1/payments/$1
