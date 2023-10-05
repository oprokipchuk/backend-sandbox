resource "kubernetes_service" "load-balancer" {
  metadata {
    name = "load-balancer"
  }
  spec {
    selector = {
      app = local.k8s_app_name
    }
    type = "LoadBalancer"
    port {
      port        = 80
      target_port = 80
    }
  }
}
