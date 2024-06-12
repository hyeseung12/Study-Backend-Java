package io.whatap.whatap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WhatapApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatapApplication.class, args);
	}

}
