package pt.cloud.orderservice.controller;

import org.springframework.web.bind.annotation.*;

import pt.cloud.orderservice.model.OrderRequest;
import pt.cloud.orderservice.service.SqsService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final SqsService sqsService;

    public OrderController(SqsService sqsService) {
        this.sqsService = sqsService;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderRequest request) {

        String message =
                "productId=" + request.getProductId()
                        + ", quantity=" + request.getQuantity();

        sqsService.sendMessage(message);

        return "Order sent to SQS";
    }
}