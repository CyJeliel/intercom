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
