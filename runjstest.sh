#!/bin/bash

FIREFOX_COMMAND=firefox

if [[ -s /Applications/Firefox.app/Contents/MacOS/firefox-bin ]]
then
    FIREFOX_COMMAND=/Applications/Firefox.app/Contents/MacOS/firefox-bin
fi

if [[ -n "$GO_STAGE_NAME" ]]
then
    echo "We're on the CI!"
    echo "Setting up Xvfb."
    Xvfb :3 -ac &
    export DISPLAY=:3
fi

echo "Running Tests"
java -jar src/main/webapp/jasmine/jasmine-1.2.0/JsTestDriver-1.3.5.jar  --port 4224 --reset --config src/main/webapp/jasmine/jsTestDriver.conf --browser $FIREFOX_COMMAND  --tests all --raiseOnFailure true

