#! /bin/bash
echo "Running inside our script"

mkdir workspace
cd workspace

wget http://10.10.4.124:8080/jdk-7u9-linux-x64.rpm 
sudo rpm -iv jdk-7u9-linux-x64.rpm 

wget http://10.10.4.124:8080/apache-tomcat-7.0.32.tar.gz 
tar -xvzf apache-tomcat-7.0.32.tar.gz 

./apache-tomcat-7.0.32/bin/startup.sh
