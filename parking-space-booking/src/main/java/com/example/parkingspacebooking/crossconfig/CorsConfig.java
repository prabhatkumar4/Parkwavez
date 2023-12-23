//package com.example.parkingspacebooking.crossconfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//public class CorsConfig {
//	 @Bean
//	    public CorsConfigurationSource corsConfigurationSource() {
//	        CorsConfiguration configuration = new CorsConfiguration();
//	        configuration.addAllowedOrigin("http://localhost:4200"); // Allow requests from any origin
//	        configuration.addAllowedMethod("*"); // Allow all HTTP methods
//	        configuration.addAllowedHeader("*"); // Allow all headers
//	        configuration.setAllowCredentials(true); // Allow cookies, if needed
//
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        source.registerCorsConfiguration("/**", configuration);
//
//	        return source;
//	    }
//
//}
