#!/bin/bash

#rm ./src/test/generated/java/fr/ece/tweetstats/core/serviceapi/*
rm src/test/java/fr/ece/tweetstats/search/serviceapi/*.java
rm src/test/java/fr/ece/tweetstats/core/serviceapi/*.java
mvn package #-DskipTests=true