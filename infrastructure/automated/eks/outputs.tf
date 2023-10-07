output "lb_hostname" {
  description = "External dns name of the Load Balancer attached to EKS cluster"
  value       = local.k8s_lb_dns_name
}
