package com.example.custombotservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.custombotservice.dto.ChatGPTRequest;
import com.example.custombotservice.dto.ChatGPTResponse;


@RestController
@Service
@RequestMapping("/bot")
public class CustomBotController {

//	@Value("${openai.model}")
//	private String model;
//
//	@Value("${openai.api.url}")
//	private String apiURL;

	@Autowired
	private RestTemplate template;

	@GetMapping(value = "/chat")
	public String chat(@RequestParam("prompt") String prompt) {
		ChatGPTRequest request = new ChatGPTRequest("gpt-3.5-turbo", prompt);
		ChatGPTResponse chatGPTResponse = template.postForObject("https://api.openai.com/v1/chat/completions", request, ChatGPTResponse.class);
		return chatGPTResponse.getChoices().get(0).getMessage().getContent();
	}
}

