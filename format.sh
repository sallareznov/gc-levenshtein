#\bin\bash

cat $1 | grep -v '0.0 mW$' | tr ';=' ' ' | cut -d ' ' -f 4,10 > data.dat
i=0
offset=`cat data.dat | head -n 1 | cut -d ' ' -f 1`

for x in `cat data.dat` 
do 
        if [ `expr $i % 2` == 0 ] 
        then 
                echo -n `expr $x - $offset`
        else
                echo -e '\t' $x
        fi

let "i+=1";
done
