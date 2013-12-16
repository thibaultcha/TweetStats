#!/bin/bash

rm src/test/generated/java/fr/ece/tweetstats/core/serviceapi/*
mvn package #-DskipTests=true