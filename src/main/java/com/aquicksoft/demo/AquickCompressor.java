package com.aquicksoft.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackages = "com.aquicksoft.controller,com.aquicksoft.service,com.aquicksoft.dto,com.aquicksoft.repository,com.aquicksoft.entities")
@SpringBootApplication
//@EnableJpaRepositories("com.aquicksoft.repository")
@EnableMongoRepositories("com.aquicksoft.repository")
@EntityScan("com.aquicksoft.entities")
public class AquickCompressor {

	public static void main(String[] args) {
		SpringApplication.run(AquickCompressor.class, args);
	}

}
