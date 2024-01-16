package com.attraya.controller;

import com.attraya.dto.PaymentRequest;
import com.attraya.dto.PaytmRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class PaytmController {

    @Value("${paytm.producer.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/publish/{message}")
    public void sendMessage(@PathVariable String message){
        for (int i=0; i<=1000; i++){
            kafkaTemplate.send(topicName, message+i);
        }
    }

    @PostMapping("/paytm/payment")
    public String doPayment(@RequestBody PaytmRequest<PaymentRequest> paytmRequest) throws JsonProcessingException {
        for(int i =0; i<100000; i++) {
            PaymentRequest paymentRequest = paytmRequest.getPayload();
            paymentRequest.setSourceAccount("SRC_ACC"+i);
            paymentRequest.setDestinationAccount("DESTN_ACC"+i);
            paymentRequest.setAmount(500+i);
            paymentRequest.setTransactionId(UUID.randomUUID().toString());
            paymentRequest.setTransactionDate(new Date());
            kafkaTemplate.send(topicName, paymentRequest); // payment-topic1 has 3 partition
        }
        return "Payment Instantiated Successfully :)";
    }
}
