#!/bin/bash

curl -v -i -H "Content-Type:application/json" -d '{"amount":0.0,"payed":""}' http://127.0.0.1:8080/payments
