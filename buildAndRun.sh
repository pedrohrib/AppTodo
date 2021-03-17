#!/bin/sh
mvn clean package && docker build -t br.edu.unipam/appTodo .
docker rm -f appTodo || true && docker run -d -p 9080:9080 -p 9443:9443 --name appTodo br.edu.unipam/appTodo