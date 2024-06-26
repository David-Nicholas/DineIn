package com.ic.dinin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DininApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(DininApplication.class)
				.profiles(
						SpringProfiles.PROD
				)
				.run(args);
	}

}
