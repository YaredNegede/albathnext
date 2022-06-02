package com.albathanext;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Log
@SpringBootApplication
@EnableFeignClients
public class AlbathanextApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(AlbathanextApplication.class, args);
	}

}
