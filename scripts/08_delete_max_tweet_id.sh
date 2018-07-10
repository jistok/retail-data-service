#!/bin/bash

. $( dirname $0 )/header.sh

user="someuser"
time curl -k -X DELETE $URL/tweetInfo/$user

