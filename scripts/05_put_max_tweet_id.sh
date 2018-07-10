#!/bin/bash

. $( dirname $0 )/header.sh

curl -k -H "Content-Type: application/json" -X PUT -d 123456789 $URL/tweetInfo/someuser

