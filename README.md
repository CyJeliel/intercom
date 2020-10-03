# Intercom

## How to build and deploy the application 
### Prerequisites:
Docker and Docker Compose installed in the machine

Instructions for installing Docker Compose: https://docs.docker.com/compose/install/

Git command line

### Instructions for Linux or Mac OS - Automation Script

Run the following command line:

curl -s https://raw.githubusercontent.com/CyJeliel/intercom/master/intercom/intercom.sh | bash

### Instructions for Linux or Mac OS (in case the Automation Script does not work) - Step By Step

$ mkdir projectCindyIntercom

$ cd projectCindyIntercom

$ git clone git@github.com:CyJeliel/intercom.git

$ cd intercom/intercom

$ docker-compose up

### Instructions for Windows - Step By Step

In Windows OS:

cd ~/Documents/

mkdir projectCindyIntercom

cd projectCindyIntercom/

git clone git@github.com:CyJeliel/intercom.git

cd intercom/intercom

docker-compose up

## Tests
The tests can be found in the following directory:
https://github.com/CyJeliel/intercom/tree/master/intercom/src/test/java/com/intercom

Tests are automatically run when running 

    docker-compose up

from the command line.

The results are similar to the following lines:

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.intercom.CustomerReaderTest
Oct 03, 2020 8:29:39 PM com.intercom.CustomerReader read
SEVERE: Invalid file format. This program expects a well formed JSON file and got a different input. Aborting proccess. java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $
Oct 03, 2020 8:29:39 PM com.intercom.CustomerReader read
SEVERE: Invalid file format. This program expects a well formed JSON file and got a different input. Aborting proccess. java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 2 path $
Oct 03, 2020 8:29:39 PM com.intercom.CustomerReader read
SEVERE: Invalid format for latitude or longitude. This program expects a number and got a different input. Aborting proccess. For input string: "ABC"
Oct 03, 2020 8:29:39 PM com.intercom.CustomerReader read
SEVERE: File not found. Aborting proccess.
Oct 03, 2020 8:29:39 PM com.intercom.CustomerReader read
SEVERE: File not found. Aborting proccess.
Oct 03, 2020 8:29:39 PM com.intercom.CustomerReader read
SEVERE: File not found. Aborting proccess. LOREM IPSUM (No such file or directory)
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.294 sec - in com.intercom.CustomerReaderTest
Running com.intercom.DistanceCalculatorTest
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.018 sec - in com.intercom.DistanceCalculatorTest
Running com.intercom.CustomerInvitationTest
Oct 03, 2020 8:29:39 PM com.intercom.CustomerReader read
SEVERE: Invalid file format. This program expects a well formed JSON file and got a different input. Aborting proccess. java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $
Oct 03, 2020 8:29:39 PM com.intercom.CustomerInvitation inviteCustomers
INFO: There were no customers within the 100km range.
Oct 03, 2020 8:29:39 PM com.intercom.CustomerInvitation inviteCustomers
INFO: There were no customers within the 100km range.
Oct 03, 2020 8:29:39 PM com.intercom.CustomerReader read
SEVERE: Invalid format for latitude or longitude. This program expects a number and got a different input. Aborting proccess. For input string: "ABC"
Oct 03, 2020 8:29:39 PM com.intercom.CustomerInvitation inviteCustomers
INFO: There were no customers within the 100km range.
Oct 03, 2020 8:29:39 PM com.intercom.CustomerReader read
SEVERE: Invalid file format. This program expects a well formed JSON file and got a different input. Aborting proccess. java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 2 path $
Oct 03, 2020 8:29:39 PM com.intercom.CustomerInvitation inviteCustomers
INFO: There were no customers within the 100km range.
Oct 03, 2020 8:29:39 PM com.intercom.CustomerInvitation inviteCustomers
INFO: There were 16 customers within the 100km range. You can find the description in the file: src/main/resources/output.txt
Oct 03, 2020 8:29:39 PM com.intercom.CustomerInvitation inviteCustomers
INFO: There were 16 customers within the 100km range. You can find the description in the file: src/main/resources/outputValidFileMissingFields.txt
Oct 03, 2020 8:29:39 PM com.intercom.CustomerInvitation inviteCustomers
INFO: There were 16 customers within the 100km range. You can find the description in the file: src/main/resources/outputValidFileMoreFields.txt
Oct 03, 2020 8:29:39 PM com.intercom.CustomerReader read
SEVERE: File not found. Aborting proccess. src/main/resources/customersFileDoesNotExist.txt (No such file or directory)
Oct 03, 2020 8:29:39 PM com.intercom.CustomerInvitation inviteCustomers
INFO: There were no customers within the 100km range.
Oct 03, 2020 8:29:39 PM com.intercom.CustomerInvitation inviteCustomers
INFO: There were 16 customers within the 100km range. You can find the description in the file: src/main/resources/outputValidExtraLines.txt
Oct 03, 2020 8:29:39 PM com.intercom.CustomerInvitation inviteCustomers
INFO: There were 13 customers within the 100km range. You can find the description in the file: src/main/resources/outputValidFileWrongField.txt
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.092 sec - in com.intercom.CustomerInvitationTest

Results :

Tests run: 26, Failures: 0, Errors: 0, Skipped: 0

## Output file
https://raw.githubusercontent.com/CyJeliel/intercom/master/intercom/src/main/resources/output.txt
