data "aws_route53_zone" "zone" {
  name = var.domain
}

data "aws_elb_hosted_zone_id" "main" {}

resource "aws_route53_record" "record" {
  zone_id = data.aws_route53_zone.zone.zone_id
  name    = "sandbox.${data.aws_route53_zone.zone.name}"
  type    = "A"

  alias {
    name                   = local.k8s_lb_dns_name
    zone_id                = data.aws_elb_hosted_zone_id.main.id
    evaluate_target_health = false
  }
}