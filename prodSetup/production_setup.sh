#! /bin/bash
echo "Running inside our script"
rm -f workspace:
mkdir workspace
cd workspace

wget https://dl.dropbox.com/u/56567206/jdk-7u9-linux-x64.rpm 
rpm -iv jdk-7u9-linux-x64.rpm 

wget http://apache.techartifact.com/mirror/tomcat/tomcat-7/v7.0.32/bin/apache-tomcat-7.0.32.tar.gz 
tar -xvzf apache-tomcat-7.0.32.tar.gz 

./apache-tomcat-7.0.32/bin/startup.sh