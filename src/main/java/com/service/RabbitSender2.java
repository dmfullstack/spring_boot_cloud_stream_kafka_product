package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import com.Barista;
import com.domain.Product;

//绑定的通道也可以直接注入。
@Component
public class RabbitSender2 {

	//可以通过@Autowired注入绑定接口，但有时候我们会创建多个不同名的MessageChannel实例，这时需要使用@Qualifier注解来特别指定具体实例的名称。
	@Qualifier(Barista.OUTPUT_CHANNEL)
	@Autowired
	private MessageChannel output;

    // 发送消息
    public String sendMessage(){
        try{
        	Product obj = new Product("1", "生产对象");
        	output.send(MessageBuilder.withPayload(obj).build());
            System.out.println("发送");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

	//每两秒钟往Barista.OUTPUT_CHANNEL通道发消息
    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000", maxMessagesPerPoll = "1"))
    public MessageSource<String> timerMessageSource() {
        return () -> MessageBuilder.withPayload((new SimpleDateFormat("dd/mm/yyyy-HH:mm:ss").format(new Date())))
                        .build();
    }

}