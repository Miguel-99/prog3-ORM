@echo off
call mvn clean package
call docker build -t com.example/prog3_tp3 .
call docker rm -f prog3_tp3
call docker run -d -p 9080:9080 -p 9443:9443 --name prog3_tp3 com.example/prog3_tp3