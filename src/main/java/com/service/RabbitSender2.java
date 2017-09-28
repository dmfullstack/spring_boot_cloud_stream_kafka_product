package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

}