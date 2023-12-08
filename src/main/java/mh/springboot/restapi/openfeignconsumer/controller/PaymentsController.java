package mh.springboot.restapi.openfeignconsumer.controller;


import mh.springboot.restapi.openfeignconsumer.model.Payment;
import mh.springboot.restapi.openfeignconsumer.proxy.PaymentProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {

    private final Logger logger = Logger.getLogger(PaymentsController.class.getName());
    private final PaymentProxy paymentProxy;

    public PaymentsController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/pay")
    public Payment makePayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        logger.info("Received payment request on : " + payment + "; Request has got the following requestId=" + requestId);
        Payment result = paymentProxy.createPayment(requestId, payment);
        logger.info("External payment system returned the following respond body: " + result);
        return result;
    }
}
