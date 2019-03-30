#!/bin/bash

. $( dirname $0 )/header.sh

time curl -k -X GET $URL/tweetInfo/maxTweetIds

