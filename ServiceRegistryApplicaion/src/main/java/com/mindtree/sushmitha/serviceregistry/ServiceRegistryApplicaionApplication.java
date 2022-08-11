package com.mindtree.sushmitha.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplicaionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplicaionApplication.class, args);
	}

}
