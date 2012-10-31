#!/bin/bash
Xvfb :99 -ac &
PID_XVFB="$!"
export DISPLAY=:99