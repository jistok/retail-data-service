#!/bin/bash

user="someuser"
endpoint="http://localhost:8080/tweetInfo"

time curl -X DELETE $endpoint/$user

