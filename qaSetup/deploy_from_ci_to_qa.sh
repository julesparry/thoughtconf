#! /bin/bash

##########################################
## This script works when there's an #####
## existing trusted connection between ###
## CI machine and QA machine #############
##########################################

#path to pull war from ci machine
sourceFilePath=/var/lib/go-agent/pipelines/CI/build/dist/thoughtconf.war

#user on qa machine
user=thoughtconf

#qa machine ip
QA_ip="10.10.4.126"

#path to deploy war to on qa machine
deployPath=/home/thoughtconf/workspace/apache-tomcat-7.0.32/webapps/


#command to deploay war file from war path on CI to correct path on qa
scp $sourceFilePath $user"@"$QA_ip":/"$deployPath 







