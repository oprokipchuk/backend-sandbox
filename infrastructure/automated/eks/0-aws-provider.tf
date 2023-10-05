provider "aws" {
  region = "eu-central-1"
}

terraform {
  backend "s3" {
    bucket = "backend-sandbox-terraform-state"
    key    = "eks/terraform.tfstate"
    region = "eu-central-1"
  }
}
