#!/bin/bash

hdfs dfs -rm -r cross_corelation/output

hadoop jar cross_corelation.jar mirea.student.shayko.bigdata_lab2.Main cross_corelation/input cross_corelation/output

hdfs dfs -cat cross_corelation/output/part-r-00000
