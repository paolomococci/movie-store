#!/bin/bash

curl -v -i -H "Content-Type:application/json" -d '{"name":"","nickname":"","surname":"","phone":"","mobile":"","email":"","birthday":"","active":true}' http://127.0.0.1:8080/customers
