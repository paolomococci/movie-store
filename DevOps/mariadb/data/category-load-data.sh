#!/bin/bash

curl -v -i -H "Content-Type:application/json" -d '{"name":"","description":""}' http://127.0.0.1:8080/categories
