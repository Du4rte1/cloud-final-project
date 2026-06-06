resource "aws_sqs_queue" "dlq" {
  name = "cloud-project-dlq"
}

resource "aws_sqs_queue" "orders" {
  name = "cloud-project-orders"

  redrive_policy = jsonencode({
    deadLetterTargetArn = aws_sqs_queue.dlq.arn
    maxReceiveCount     = 5
  })
}