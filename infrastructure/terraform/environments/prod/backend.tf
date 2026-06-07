terraform {
  backend "s3" {
    bucket         = "cloud-project-duarte-bucket"
    key            = "prod/terraform.tfstate"
    region         = "eu-west-1"
    dynamodb_table = "cloud-project-tf-locks"
    encrypt        = true
  }
}