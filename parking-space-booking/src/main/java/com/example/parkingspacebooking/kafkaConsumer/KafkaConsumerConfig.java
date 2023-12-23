package com.example.parkingspacebooking.kafkaConsumer;
/*
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.parkingspacebooking.Model.UserDTO;


@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
	    Map<String, Object> config = new HashMap<>();
	    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    // Other consumer config settings...
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
        config.put(ConsumerConfig.GROUP_ID_CONFIG,4);
	    JsonDeserializer<String> jsonDeserializer = new JsonDeserializer<>(String.class);
	    jsonDeserializer.setUseTypeHeaders(false);

	    ErrorHandlingDeserializer<String> errorHandlingDeserializer = new ErrorHandlingDeserializer<>(jsonDeserializer);

	    return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), errorHandlingDeserializer);
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,String>kafkaListenerContainer(){
		
		ConcurrentKafkaListenerContainerFactory<String,String> factory= new ConcurrentKafkaListenerContainerFactory<String,String>();
	factory.setConsumerFactory(consumerFactory());
	return factory;
	}

}
*/