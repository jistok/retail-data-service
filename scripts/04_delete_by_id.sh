#!/bin/bash

id="867912355610583041"
endpoint="http://localhost:8080/retailEvent"

time curl -X DELETE $endpoint/$id

