locals {
  k8s_app_name = "hello-world"
  k8s_lb_dns_name = kubernetes_service.load-balancer.status.0.load_balancer.0.ingress.0.hostname
}

variable "cluster_name" {
  type = string
  description = "Name of the EKS cluster"
}

variable "domain" {
  type = string
  description = "Registered name of the domain used to publish the EKS cluster"
}

variable "addons" {
  type = list(object({
    name    = string
    version = string
  }))

  default = [
    {
      name    = "aws-ebs-csi-driver"
      version = "v1.23.1-eksbuild.1"
    }
  ]
}
