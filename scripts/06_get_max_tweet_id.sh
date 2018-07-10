#!/bin/bash

. $( dirname $0 )/header.sh

curl -k -X GET $URL/tweetInfo/someuser/maxTweetId

