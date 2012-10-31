#!/bin/bash
Xvfb :2 -ac &
PID_XVFB="$!"
export DISPLAY=:2