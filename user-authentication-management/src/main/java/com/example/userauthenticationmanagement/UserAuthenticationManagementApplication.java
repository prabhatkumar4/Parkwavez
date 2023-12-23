package com.example.userauthenticationmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserAuthenticationManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationManagementApplication.class, args);
	}

}

