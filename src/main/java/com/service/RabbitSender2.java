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

	//如果通道名称是在声明的注解上指定的，则不能使用方法名称，而要使用通道名称。举例如下：
	//@Output("customOutput")
	//MessageChannel output();
	@Qualifier(Barista.INPUT_CHANNEL)
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