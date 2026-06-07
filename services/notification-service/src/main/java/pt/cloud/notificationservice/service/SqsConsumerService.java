package pt.cloud.notificationservice.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.List;

@Service
public class SqsConsumerService {

    @Value("${sqs.queue-url}")
    private String queueUrl;

    private SqsClient sqsClient;

    @PostConstruct
    public void startConsumer() {

        sqsClient = SqsClient.builder()
                .region(Region.EU_WEST_1)
                .build();

        Thread thread = new Thread(() -> {

            while (true) {

                try {

                    ReceiveMessageRequest request =
                            ReceiveMessageRequest.builder()
                                    .queueUrl(queueUrl)
                                    .maxNumberOfMessages(10)
                                    .waitTimeSeconds(20)
                                    .build();

                    List<Message> messages =
                            sqsClient.receiveMessage(request).messages();

                    for (Message message : messages) {

                        System.out.println("=================================");
                        System.out.println("ORDER RECEIVED");
                        System.out.println(message.body());
                        System.out.println("=================================");

                        DeleteMessageRequest deleteRequest =
                                DeleteMessageRequest.builder()
                                        .queueUrl(queueUrl)
                                        .receiptHandle(message.receiptHandle())
                                        .build();

                        sqsClient.deleteMessage(deleteRequest);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

        thread.start();
    }
}