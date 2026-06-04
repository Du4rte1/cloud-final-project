module "vpc" {
  source = "../../modules/vpc"

  vpc_cidr = "10.0.0.0/16"

  public_subnet_a_cidr = "10.0.1.0/24"
  public_subnet_b_cidr = "10.0.2.0/24"

  private_subnet_a_cidr = "10.0.3.0/24"
  private_subnet_b_cidr = "10.0.4.0/24"
}

module "ec2" {
  source = "../../modules/ec2"

  vpc_id    = module.vpc.vpc_id
  subnet_id = module.vpc.public_subnet_a_id

  key_name = "cloud-project-key"
}

module "rds" {
  source = "../../modules/rds"

  vpc_id = module.vpc.vpc_id

  private_subnet_a_id = module.vpc.private_subnet_a_id
  private_subnet_b_id = module.vpc.private_subnet_b_id
}

module "sqs" {
  source = "../../modules/sqs"
}