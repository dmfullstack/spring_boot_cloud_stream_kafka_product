package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.Barista;
import com.domain.Product;

@Component
public class RabbitSender {

	private Barista source;

    @Autowired
    public RabbitSender(Barista source) {
        this.source = source;
    }

    // 发送消息
    public String sendMessage(){
        try{
        	Product obj = new Product("1", "生产对象");
            source.logOutPut().send(MessageBuilder.withPayload(obj).build());
            System.out.println("发送");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @StreamListener(Barista.INPUT_CHANNEL)
	public void netshoesProducts(Product product) {
    	System.out.println("接受反馈对象2:" + product);
	}

}