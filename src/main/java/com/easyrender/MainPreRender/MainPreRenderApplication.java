package com.easyrender.MainPreRender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MainPreRenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainPreRenderApplication.class, args);
	}

}
