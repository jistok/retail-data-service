#!/bin/bash

user="someuser"

curl -X GET http://localhost:8080/tweetInfo/$user/maxTweetId

