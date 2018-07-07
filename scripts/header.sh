#!/bin/bash

if [ -z $URL ]
then
  cat <<EoM
Environment variable 'url' must be set to the URL of your service

  e.g. export URL=http://retail-data-service.apps.my-pcf.com


EoM
  exit 1
fi


