package mh.springboot.restapi.openfeignconsumer.proxy;

import mh.springboot.restapi.openfeignconsumer.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments", url = "${payments.service.url}")
public interface PaymentProxy {

    @PostMapping(path = "/payment")
    Payment createPayment(@RequestHeader String requestId, @RequestBody Payment payment);
}
