package com.example.custombotservice.config;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIConfig {
	
//	@Value("${openai.api.key}")
//	String openaiApiKey;

	@Bean
	public RestTemplate template(){
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("Authorization", "Bearer " + "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");
			return execution.execute(request, body);
		});
		return restTemplate;
	}

}
