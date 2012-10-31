#!/bin/bash
Xvfb :3 -ac &
PID_XVFB="$!"
export DISPLAY=:3
export PID_XVFB