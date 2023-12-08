package mh.springboot.restapi.openfeignconsumer.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("mh.springboot.restapi.openfeignconsumer.proxy")
public class AppConfig {

}
