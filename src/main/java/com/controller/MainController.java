package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.RabbitSender;
import com.service.RabbitSender2;

@RestController
public class MainController {

	@Autowired
	private RabbitSender rabbitSender;
	@Autowired
	private RabbitSender2 rabbitSender2;

	//http://localhost:8089/sendMessage
	@GetMapping("/sendMessage")
	public void sendMessage() {
		rabbitSender.sendMessage();
	}

	//http://localhost:8089/sendMessage2
	@GetMapping("/sendMessage2")
	public void sendMessage2() {
		rabbitSender2.sendMessage();
	}

}