#!/bin/bash
jobs &>/dev/null
time python3 Main.py ../dictionary_EN.txt &
new_job_started="$(jobs -n)"
if [ -n "$new_job_started" ];then
    VAR=$!
else
    VAR=
fi
echo $VAR
../powerapi-iagl-3.3/bin/powerapi 60 500 $VAR
MOVE=mv powerapi.out output/powerapi_python.out
MOVE || { mkdir output && MOVE } 
