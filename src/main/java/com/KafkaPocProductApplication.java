package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(Barista.class)
//@EnableBinding({Barista.class})//可以传多个类，处理多个通道(主题)
public class KafkaPocProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPocProductApplication.class, args);
	}

}
