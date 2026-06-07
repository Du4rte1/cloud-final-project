# Cloud Final Project

## Overview

This project implements a cloud-native distributed application deployed on AWS using Infrastructure as Code, containerization, event-driven communication, and CI/CD practices.

## Architecture

The solution consists of three microservices:

* Catalog Service
* Order Service
* Notification Service

### Flow

Catalog Service → PostgreSQL (RDS)

Order Service → Amazon SQS → Notification Service

## Technologies

* AWS EC2
* AWS RDS PostgreSQL
* AWS SQS
* Terraform
* Docker
* GitHub Actions
* Ansible
* Spring Boot
* Java 21

## Infrastructure

The infrastructure is provisioned using Terraform and includes:

* Custom VPC
* Public and private subnets
* Route tables
* Security groups
* Internet Gateway
* EC2 Instance
* RDS PostgreSQL
* SQS Queue
* Dead Letter Queue

## Services

### Catalog Service

Provides catalog management and stores data in PostgreSQL.

Endpoints:

* GET /catalog
* POST /catalog

### Order Service

Receives orders and publishes messages to Amazon SQS.

Endpoints:

* POST /orders

### Notification Service

Consumes messages from Amazon SQS and processes order notifications.

## Deployment

The application is containerized with Docker and deployed automatically through GitHub Actions.

## CI/CD

GitHub Actions performs:

* Build
* Docker image creation
* Push to Docker Hub
* Automatic deployment to EC2

## Security

Sensitive information is stored using GitHub Secrets and injected as environment variables during deployment.
