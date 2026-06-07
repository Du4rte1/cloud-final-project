# Deployment Guide

## Prerequisites

* AWS Account
* Terraform
* Docker
* GitHub Account

## Infrastructure Deployment

terraform init

terraform plan

terraform apply

## Application Deployment

Deployment is automated through GitHub Actions.

Each push to the main branch triggers:

1. Docker image build
2. Docker Hub push
3. EC2 deployment

## Verification

Check running containers:

docker ps

Check services:

curl http://localhost:8081/catalog

curl -X POST http://localhost:8082/orders
