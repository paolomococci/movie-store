#!/bin/bash

curl -v -i -H "Content-Type:application/json" -d '{"title":"","subtitle":"","description":"","comeout":"","duration":"","cost":0.0,"rent":0.0,"rating":0.0}' http://127.0.0.1:8080/movies
