#!/bin/sh
mvn clean package && docker build -t com.example/prog3_tp3 .
docker rm -f prog3_tp3 || true && docker run -d -p 9080:9080 -p 9443:9443 --name prog3_tp3 com.example/prog3_tp3