# Architecture

## Components

### Catalog Service

Responsible for product catalog management.

Stores information in PostgreSQL running on AWS RDS.

### Order Service

Receives order requests.

Publishes asynchronous messages to Amazon SQS.

### Notification Service

Consumes messages from Amazon SQS.

Processes notifications independently from the Order Service.

## Event-Driven Communication

Order Service acts as a producer.

Notification Service acts as a consumer.

Amazon SQS provides decoupling between services.

## Infrastructure Diagram

Client
│
├── Catalog Service (EC2)
│ └── RDS PostgreSQL
│
└── Order Service (EC2)
│
└── Amazon SQS
│
└── Notification Service (EC2)
