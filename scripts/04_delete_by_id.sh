#!/bin/bash

. $( dirname $0 )/header.sh

id="867912355610583041"
time curl -k -X DELETE $URL/retailEvent/$id

