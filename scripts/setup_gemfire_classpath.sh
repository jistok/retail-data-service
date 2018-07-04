#!/bin/bash

set -e

project_root=$( dirname $0 )/..
project_root=$( realpath $project_root )
boot_jar=$project_root/target/data-service-0.0.1-SNAPSHOT.jar
cwd=$( pwd )
dir="/tmp/jars.$$"
mkdir $dir
cd $dir/
unzip $boot_jar > /dev/null 2>&1
cp="$dir/BOOT-INF/classes"
for jar in $( find $dir -name '*.jar' )
do
  cp="$cp:$jar"
done
cd $cwd
echo "export CLASSPATH=$cp"

