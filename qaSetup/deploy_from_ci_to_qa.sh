#!/bin/bash

#path to pull war from ci machine
sourcFilePath = /var/lib/go-agent/pipelines/CI/build/dist/app.war

#user on qa machine
user = root

#qa machine ip
QA_ip = 10.10.4.124

#path to deploy war to on qa machine
deployPath =/root/Test/ 


scp $sourcePath $user"@"QA_ip":/"$deployPath 
