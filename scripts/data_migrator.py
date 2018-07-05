#!/usr/bin/env python

import sys
import json
import requests

MAX_TWEETS_PER_USER = 10000

if len(sys.argv) != 3:
  print "Usage: %s source_URL dest_URL" % sys.argv[0]
  sys.exit(1)

src = sys.argv[1]
dest = sys.argv[2]

# Fetch the list of {"user": maxTweetId}, from which we only need the user portion
def getMaxTweetIds():
  rv = []
  r = requests.get(src + "/tweetInfo/maxTweetIds")
  if (r.status_code == 200):
    rv = r.json()
  return rv

# Store the JSON via the persistence service
def storeJson(jsonStr):
  headers = { "Content-Type": "application/json" }
  r = requests.put(dest + "/retailEvent/event", headers=headers, data=jsonStr)
  return r.status_code == 200

# Start the migration
for resp in getMaxTweetIds():
  screenName = (resp.keys())[0]
  print "Screen name: %s" % screenName
  r = requests.get(src + "/retailEvent/" + screenName + "/" + str(MAX_TWEETS_PER_USER))
  if r.status_code != 200:
    raise Exception("Failed to get tweets for user %s" % screenName)
  tweetList = r.json()
  for tweet in tweetList:
    storeJson(json.dumps(tweet))

