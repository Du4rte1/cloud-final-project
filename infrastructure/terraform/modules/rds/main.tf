resource "aws_security_group" "rds" {
  name        = "cloud-project-rds-sg"
  description = "RDS Security Group"
  vpc_id      = var.vpc_id

  ingress {
    from_port   = 5432
    to_port     = 5432
    protocol    = "tcp"
    cidr_blocks = ["10.0.0.0/16"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_db_subnet_group" "main" {
  name = "cloud-project-db-subnet-group"

  subnet_ids = [
    var.private_subnet_a_id,
    var.private_subnet_b_id
  ]

  tags = {
    Name = "cloud-project-db-subnet-group"
  }
}

resource "aws_db_instance" "postgres" {
  identifier = "cloud-project-db"

  engine         = "postgres"
  engine_version = "16"

  instance_class = "db.t3.micro"

  allocated_storage = 20
  storage_type      = "gp3"

  db_name  = "cloudproject"
  username = "postgres"
  password = "Cloud123!"

  publicly_accessible = false

  vpc_security_group_ids = [
    aws_security_group.rds.id
  ]

  db_subnet_group_name = aws_db_subnet_group.main.name

  skip_final_snapshot = true
}