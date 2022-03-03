#Auth Service
Which include the functions sign-up, sign-in, create and remove JWT token
##Using Spring Boot, MySQL, Docker

- --
This guide will let you how to use build and run the application using Dockerfile

## Check docker works fine
###1. Run docker example container
```
% docker run -d -p 80:80 docker/getting-started
```

##Run application using Dockerfile
###1. create network
```
% docker network create backend-network
% docker network ls
```

###2. create mysql container
```
% docker pull --platform linux/x86_64 mysql
% docker image ls
% docker run --network backend-network --name mysql-container -e MYSQL_ROOT_PASSWORD=mzMysql123 -e MYSQL_DATABASE=mz_db_user --platform linux/x86_64 -d mysql:latest
% docker container ls
```

Access to container and login to mysql with user root

```
% docker exec -it mysql-container bash
# mysql -uroot -p
```

###3. create auth-service container
```
% gradle clean build
```
_it should build source code before build docker image_
```
% docker build -t admin-service .
% docker image ls
% docker run --network backend-network --name auth-service-container -p 8080:8080 -d auth-service
% docker container ls
```

##Other notes:

###1. Check ip container

```
% docker exec mysql-container cat /etc/hosts
```
ref: https://www.freecodecamp.org/news/how-to-get-a-docker-container-ip-address-explained-with-examples/

###2. How to install telnet into a alpine docker container
```
% apk update

% apk add busybox-extras

% busybox-extras telnet localhost 6900
```

###3. Pushing the docker image to docker hub
- Tag local docker image to the repository tag by command line below
```
% docker tag image username/repository:tag
```
```
% docker tag auth-service williamhuanle/auth-service:0.0.1-SNAPSHOT
```
- Push the image to docker hub
```
% docker push williamhuanle/auth-service:0.0.1-SNAPSHOT 
```

- Pulling the image from docker hub and running it

```
docker run --network backend-network --name auth-service-container -p 8080:8080 williamhuanle/auth-service:0.0.1-SNAPSHOT
```
