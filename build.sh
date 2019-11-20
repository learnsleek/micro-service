#!/bin/sh
source /etc/environment 
echo "#----------Build Start------------#"

cd micro-discovery
mvn clean install -U

cd ../micro-gateway
mvn clean install -U
java -DEUREKAHOST=172.16.28.16 -jar target/gateway-0.0.1-SNAPSHOT.jar &

cd ../micro-auth
mvn clean install -U
java -DEUREKAHOST=172.16.28.16 -jar target/auth-0.0.1-SNAPSHOT.jar &

cd ../micro-core
mvn clean install -U
java -DEUREKAHOST=172.16.28.16 -jar target/core-0.0.1-SNAPSHOT.jar &

cd ../micro-func
mvn clean install -U
java -DEUREKAHOST=172.16.28.16 -jar target/func-0.0.1-SNAPSHOT.jar &

echo "#----------Build End------------#"



#docker-compose build
