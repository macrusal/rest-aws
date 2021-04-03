# REST-AWS
Curso - Udemy

https://www.udemy.com/course/restful-apis-do-0-a-nuvem-com-springboot-e-docker

# Arquitetura da Aplicação
* Java 11
* Git
* Spring Boot(com servidor Tomcat embarcado)
* Lombok
* MongoDB
* Docker


# Docker-Compose
```
version: "3.7"
services:
  mongo_udemy_rest_aws:
    container_name: mongo_udemy_rest_aws
    image: mongo:3.6
    ports:
      - "27018:27017"
    volumes:
      - /Users/marcelo/desenvolvimento/database/docker-mongodb:/data/db
    restart: unless-stopped
```
docker-compose up
docker-compose down
