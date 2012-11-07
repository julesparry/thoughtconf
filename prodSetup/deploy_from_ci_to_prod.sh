#! /bin/bash

##########################################
## This script works when there's an #####
## existing trusted connection between ###
## CI machine and PROD machine #############
##########################################

#path to pull war from ci machine
sourceFilePath=/var/lib/go-agent/pipelines/CI/build/dist/thoughtconf.war

#user on prod machine
user=thoughtconf

#prod machine ip
PROD_ip="10.10.4.125"

#path to deploy war to on prod machine
deployPath=/home/thoughtconf/workplace/workspace/apache-tomcat-7.0.32/webapps/


#command to deploy war file from war path on CI to correct path on prod 
scp $sourceFilePath $user"@"$PROD_ip":/"$deployPath 







