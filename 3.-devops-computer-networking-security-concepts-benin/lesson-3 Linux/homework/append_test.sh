#!/bin/bash
for times in {1..1000}
do
    echo $(date) >> /tmp/timestamp.log
    times=$(($times+1))
    sleep 1
done