package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableEurekaClient
//该注解用来指定一个或多个定义了@Input或@Output注解的接口，以此实现对消息通道德绑定
@EnableBinding({Barista.class, Source.class})
//@EnableBinding({Barista.class})//可以传多个类，处理多个通道(主题)
public class KafkaPocProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPocProductApplication.class, args);
	}

}
