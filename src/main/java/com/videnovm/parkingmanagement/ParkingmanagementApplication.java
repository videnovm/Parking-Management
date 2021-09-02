package com.videnovm.parkingmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.videnovm.parkingmanagement.controller"})
@ComponentScan({"com.videnovm.parkingmanagement.service"})
@EntityScan("com.videnovm.parkingmanagement.model")
@EnableJpaRepositories("com.videnovm.parkingmanagement.repository")
public class ParkingmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingmanagementApplication.class, args);
	}

}
