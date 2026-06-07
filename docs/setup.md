# Setup Guide

## Clone Repository

git clone https://github.com/Du4rte1/cloud-final-project.git

## Configure GitHub Secrets

Required secrets:

* AWS_ROLE_TO_ASSUME
* DB_URL
* DB_USERNAME
* DB_PASSWORD
* DOCKERHUB_USERNAME
* DOCKERHUB_TOKEN
* EC2_HOST
* EC2_SSH_KEY

## Build Services

Catalog Service:

mvn clean package

Order Service:

mvn clean package

Notification Service:

mvn clean package

## Local Docker Build

docker build -t catalog-service .

docker build -t order-service .

docker build -t notification-service .
