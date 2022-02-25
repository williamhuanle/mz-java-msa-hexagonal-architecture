#Docker

###1. create network
   % docker network create admin-mysql-network
   % docker network ls


###2. create mysql container

% docker pull --platform linux/x86_64 mysql
% docker run --network admin-mysql-network --name mysql-container -e MYSQL_ROOT_PASSWORD=mzMysql123@ -e MYSQL_DATABASE=mz_db_admin --platform linux/x86_64 -d mysql:latest



###3. create admin-service

% docker build -t admin-service .
% docker run --network admin-mysql-network --name admin-service-container -p 8081:8081 -d admin-service


docker run --network admin-mysql-network --name admin-service-container  --link mysql-container:mysql-container -p 8081:8081 -d admin-service


###4. example
   docker run --network admin-mysql-network -d -p 80:80 docker/getting-started

###5. check ip container

docker exec mysql-container cat /etc/hosts
https://www.freecodecamp.org/news/how-to-get-a-docker-container-ip-address-explained-with-examples/


###6. How to install telnet into a alpine docker container

>>> docker exec -it CONTAINERID /bin/sh
/app # telnet
/bin/sh: telnet: not found

/app # apk update
fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/main/x86_64/APKINDEX.tar.gz
fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/community/x86_64/APKINDEX.tar.gz
v3.7.0-243-gf26e75a186 [http://dl-cdn.alpinelinux.org/alpine/v3.7/main]
v3.7.0-229-g087f28e29d [http://dl-cdn.alpinelinux.org/alpine/v3.7/community]
OK: 9051 distinct packages available

/app # apk add busybox-extras
(1/1) Installing busybox-extras (1.27.2-r11)
Executing busybox-extras-1.27.2-r11.post-install
Executing busybox-1.27.2-r7.trigger
OK: 77 MiB in 64 packages

/app # busybox-extras telnet localhost 6900