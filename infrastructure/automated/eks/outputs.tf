output "lb_hostname" {
  description = "External dns name of the Load Balancer attached to EKS cluster"
  value       = kubernetes_service.load-balancer.status.0.load_balancer.0.ingress.0.hostname
}
