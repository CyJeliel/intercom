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

    mkdir projectCindyIntercom

    cd projectCindyIntercom

    git clone git@github.com:CyJeliel/intercom.git

    cd intercom/intercom

    docker-compose up

### Instructions for Windows - Step By Step

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

    intercom    | -------------------------------------------------------
    intercom    |  T E S T S
    intercom    | -------------------------------------------------------
    intercom    | Running com.intercom.CustomerReaderTest
    intercom    | Oct 03, 2020 6:37:26 PM com.intercom.CustomerReader read
    intercom    | SEVERE: Invalid file format. This program expects a well formed JSON file and got a different input. Aborting proccess. java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerReader read
    intercom    | SEVERE: Invalid file format. This program expects a well formed JSON file and got a different input. Aborting proccess. java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 2 path $
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerReader read
    intercom    | SEVERE: Invalid format for latitude or longitude. This program expects a number and got a different input. Aborting proccess. For input string: "ABC"
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerReader read
    intercom    | SEVERE: File not found. Aborting proccess.
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerReader read
    intercom    | SEVERE: File not found. Aborting proccess.
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerReader read
    intercom    | SEVERE: File not found. Aborting proccess. LOREM IPSUM (No such file or directory)
    intercom    | Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.684 sec - in com.intercom.CustomerReaderTest
    intercom    | Running com.intercom.DistanceCalculatorTest
    intercom    | Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.068 sec - in com.intercom.DistanceCalculatorTest
    intercom    | Running com.intercom.CustomerInvitationTest
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerReader read
    intercom    | SEVERE: Invalid file format. This program expects a well formed JSON file and got a different input. Aborting proccess. java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerInvitation inviteCustomers
    intercom    | INFO: There were no customers within the 100km range.
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerInvitation inviteCustomers
    intercom    | INFO: There were no customers within the 100km range.
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerReader read
    intercom    | SEVERE: Invalid format for latitude or longitude. This program expects a number and got a different input. Aborting proccess. For input string: "ABC"
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerInvitation inviteCustomers
    intercom    | INFO: There were no customers within the 100km range.
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerReader read
    intercom    | SEVERE: Invalid file format. This program expects a well formed JSON file and got a different input. Aborting proccess. java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 2 path $
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerInvitation inviteCustomers
    intercom    | INFO: There were no customers within the 100km range.
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerInvitation inviteCustomers
    intercom    | INFO: There were 16 customers within the 100km range. You can find the description in the file: src/main/resources/output.txt
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerInvitation inviteCustomers
    intercom    | INFO: There were 16 customers within the 100km range. You can find the description in the file: src/main/resources/outputValidFileMissingFields.txt
    intercom    | Oct 03, 2020 6:37:27 PM com.intercom.CustomerInvitation inviteCustomers
    intercom    | INFO: There were 16 customers within the 100km range. You can find the description in the file: src/main/resources/outputValidFileMoreFields.txt
    intercom    | Oct 03, 2020 6:37:28 PM com.intercom.CustomerReader read
    intercom    | SEVERE: File not found. Aborting proccess. src/main/resources/customersFileDoesNotExist.txt (No such file or directory)
    intercom    | Oct 03, 2020 6:37:28 PM com.intercom.CustomerInvitation inviteCustomers
    intercom    | INFO: There were no customers within the 100km range.
    intercom    | Oct 03, 2020 6:37:28 PM com.intercom.CustomerInvitation inviteCustomers
    intercom    | INFO: There were 16 customers within the 100km range. You can find the description in the file: src/main/resources/outputValidExtraLines.txt
    intercom    | Oct 03, 2020 6:37:28 PM com.intercom.CustomerInvitation inviteCustomers
    intercom    | INFO: There were 13 customers within the 100km range. You can find the description in the file: src/main/resources/outputValidFileWrongField.txt
    intercom    | Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.755 sec - in com.intercom.CustomerInvitationTest
    intercom    |
    intercom    | Results :
    intercom    |
    intercom    | Tests run: 26, Failures: 0, Errors: 0, Skipped: 0

## Output file

After running 

    docker-compose up

for the example given in the instructions for this program, the last line should be:


    intercom    | INFO: There were 16 customers within the 100km range. You can find the description in the file: src/main/resources/output.txt
    
Following is the output file:
https://raw.githubusercontent.com/CyJeliel/intercom/master/intercom/src/main/resources/output.txt

It's possible to configure this file in the following line:
https://github.com/CyJeliel/intercom/blob/master/intercom/docker-compose.yml#L11
