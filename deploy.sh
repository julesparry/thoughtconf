#!/bin/bash

source ~/.bash_profile

ant clean

ant make-war

echo "Stopping tomcat..."
/Library/Tomcat/bin/shutdown.sh
echo "ok"

echo "Copying war to tomcat webapps dir..."
cp /Users/jparry/code/thoughtconf/build/dist/thoughtconf.war /Library/Tomcat/webapp
echo "ok"

echo "Starting tomcat..."
/Library/Tomcat/bin/startup.sh
echo "ok"

