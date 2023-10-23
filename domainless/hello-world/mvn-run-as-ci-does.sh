#!/bin/bash

set -e  # Exit on error

mvn clean install
mvn verify -DskipUnitTests=true -P integration-tests
mvn verify -DskipUnitTests=true -P component-tests
