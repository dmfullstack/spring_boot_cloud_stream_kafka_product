package com;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Barista {

	String INPUT_CHANNEL = "input_channel";
	String OUTPUT_CHANNEL = "output_channel";
	String NETSHOES_PRODUCTS = "netshoesProducts";

	//@Input注解定义了一个输入通道，应用通过该输入通道接收进入应用的消息，
	//input和output注解可以使用通道名称作为参数；如果没有名称，会使用带注解的方法的名字作为参数（也就是说，如果没有定义单独的名字，这里的通道名就是方法名logInput）
    //SubscribableChannel继承自MessageChannel接口，定义了维护消息通道丁悦者的方法
	@Input(Barista.INPUT_CHANNEL)
    SubscribableChannel logInput();

	//@Output注解定义了一个输出通道，发布的消息通过该通道离开应用。
    //MessageChannel定义了向消息通道发送消息的方法
    @Output(Barista.OUTPUT_CHANNEL)
    MessageChannel logOutPut();

    @Input
	@Output
	MessageChannel netshoesProducts();

}
