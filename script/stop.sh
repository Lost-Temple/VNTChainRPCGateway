#!/bin/bash
PID=$(ps -ef | grep vnt-chain-rpc-gateway-0.0.1.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo vnt-chain-rpc-gateway is already stopped
else
    echo kill $PID
    kill $PID
fi
