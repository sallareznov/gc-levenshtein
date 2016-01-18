#!/bin/bash
jobs &>/dev/null
java -jar target/levenshtein-1.0.jar ../dictionary_EN.txt &
new_job_started="$(jobs -n)"
if [ -n "$new_job_started" ];then
    VAR=$!
else
    VAR=
fi
echo $VAR
../../powerapi-iagl-3.3/bin/powerapi 60 500 $VAR
mv powerapi.out ../output/powerapi_java.out
