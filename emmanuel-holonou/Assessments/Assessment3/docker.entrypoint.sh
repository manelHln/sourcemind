#!/bin/bash

# Remove compiled classes
rm -rf *.class

javac -d ./out ./src/*.java

# Execute Java application and write output to new files
java ./out/production/PhoneBook/Main > output.txt
