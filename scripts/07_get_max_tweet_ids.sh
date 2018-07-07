#!/bin/bash

. $( dirname $0 )/header.sh

curl -X GET $URL/tweetInfo/maxTweetIds

