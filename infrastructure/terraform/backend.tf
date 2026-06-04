terraform {
  backend "s3" {
    bucket         = "cloud-project-duarte-bucket"
    key            = "dev/terraform.tfstate"
    region         = "eu-west-1"
    dynamodb_table = "cloud-project-tf-locks"
    encrypt        = true
  }
}