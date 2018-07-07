#!/bin/bash

. $( dirname $0 )/header.sh

user="someuser"
time curl -X DELETE $URL/tweetInfo/$user

