#!/bin/bash

. $( dirname $0 )/header.sh

id="867912355610583041"
time curl -X DELETE $URL/retailEvent/$id

