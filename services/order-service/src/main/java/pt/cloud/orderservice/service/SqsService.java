package pt.cloud.orderservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SqsService {

    private final SqsClient sqsClient;

    @Value("${sqs.queue-url}")
    private String queueUrl;

    public SqsService() {
        this.sqsClient = SqsClient.builder()
                .region(Region.EU_WEST_1)
                .build();
    }

    public void sendMessage(String message) {

        SendMessageRequest request =
                SendMessageRequest.builder()
                        .queueUrl(queueUrl)
                        .messageBody(message)
                        .build();

        sqsClient.sendMessage(request);
    }
}