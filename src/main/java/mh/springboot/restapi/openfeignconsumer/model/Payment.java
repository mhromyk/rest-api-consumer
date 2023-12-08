package mh.springboot.restapi.openfeignconsumer.model;

import java.time.LocalDateTime;

public record Payment (String paymentId, double amount, LocalDateTime paymentDate) {
}
