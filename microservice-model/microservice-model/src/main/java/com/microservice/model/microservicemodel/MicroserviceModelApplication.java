package com.microservice.model.microservicemodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages="com.cloud.dbservice.resource")
@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceModelApplication {

	public static void main(String[] args) {
		 
		SpringApplication.run(MicroserviceModelApplication.class, args);
	}
}
