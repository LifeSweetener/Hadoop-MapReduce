#!/bin/bash

hdfs dfs -rm -r cross_corelation/output

hadoop jar cross_corelation.jar mirea.student.shayko.bigdata_lab2.Main cross_corelation/input cross_corelation/output

echo -n "Enter interesting product: "
read product

output=`hdfs dfs -cat cross_corelation/output/*`

IFS=$'\n'
max=0  ## кол-во наиболее часто встречающихся пар товаров
products=("null" "null")  ## рекомендуемые товары
for line in $output
do
    edit=$line
    first=${edit%,*}
    second=${edit#*,}
    second=${second%['	']*}
    echo "first = $first second = $second"
    if [[ $product == $first || $product == $second ]]; then
        IFS=$'\t'
	for part in $line
	do
		number='^[0-9]+$'
                echo "max = $max"
		if [[ $part =~ $number ]] ; then
		    if [ $part -gt $max ]; then
			max=$part
                        
                        products[0]=${products[1]}
                        if [ $product == $first ]; then
                            products[1]=$second
                        else
                            products[1]=$first
                        fi
		    fi
		fi
    	done
    fi
    
done

echo "=================="
echo "Your recommendations: ${products[1]} and ${products[0]}!"
echo "==================="
