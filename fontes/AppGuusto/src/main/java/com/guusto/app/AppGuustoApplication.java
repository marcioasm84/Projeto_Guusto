package com.guusto.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guusto.app.services.MerchantService;
import com.guusto.app.entities.Merchant;

@SpringBootApplication
public class AppGuustoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppGuustoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(MerchantService service) {
		//Loading data from json
		return args -> {			
			List<Merchant> list = null;		
			Map<String, List<Merchant>> map = null;
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<Map<String, List<Merchant>>> typeReference = new TypeReference<>(){};				
			try {
				InputStream inputStream = TypeReference.class.getResourceAsStream("/json/merchants.json");
				map = mapper.readValue(inputStream,typeReference);
				list = map.get("list");	
				service.deleteAll();
				service.saveAll(list);
				System.out.println("Merchants Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Merchants: " + e.getMessage());
			}
		};
	}
}
