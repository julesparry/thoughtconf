#! /bin/bash

##########################################
## This script works when there's an #####
## existing trusted connection between ###
## CI machine and QA machine #############
##########################################

#path to pull war from ci machine
sourceFilePath=/var/lib/go-agent/pipelines/CI/build/dist/app.war

#user on qa machine
user=root

#qa machine ip
QA_ip="10.10.4.124"

#path to deploy war to on qa machine
deployPath=/root/Test/ 


#command to deploay war file from war path on CI to correct path on qa (temp path currently used)
scp $sourceFilePath $user"@"$QA_ip":/"$deployPath 







