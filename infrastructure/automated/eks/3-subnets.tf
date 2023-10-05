resource "aws_subnet" "public-eu-central-1a" {
  vpc_id                  = aws_vpc.vpc.id
  cidr_block              = "172.16.0.0/24"
  availability_zone       = "eu-central-1a"
  map_public_ip_on_launch = true

  tags = {
    "Name"                       = "eks-public-eu-central-1a"
    "kubernetes.io/role/elb"     = "1"
    "kubernetes.io/cluster/${local.cluster_name}" = "owned"
  }
}

resource "aws_subnet" "public-eu-central-1b" {
  vpc_id                  = aws_vpc.vpc.id
  cidr_block              = "172.16.1.0/24"
  availability_zone       = "eu-central-1b"
  map_public_ip_on_launch = true

  tags = {
    "Name"                       = "eks-public-eu-central-1b"
    "kubernetes.io/role/elb"     = "1"
    "kubernetes.io/cluster/${local.cluster_name}" = "owned"
  }
}
