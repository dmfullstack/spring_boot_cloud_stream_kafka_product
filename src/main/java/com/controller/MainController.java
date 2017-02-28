package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.RabbitSender;

@RestController
public class MainController {

	@Autowired
	private RabbitSender rabbitSender;

	//http://localhost:8089/sendMessage
	@GetMapping("/sendMessage")
	public void sendMessage() {
		rabbitSender.sendMessage();
	}

}