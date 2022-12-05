package com.cubeit.navitrackapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableAutoConfiguration
@EntityScan("com.cubeit.navitrackapi.Models")
@EnableReactiveMongoRepositories("com.cubeit.navitrackapi.Repos")
@SpringBootApplication
public class NavitrackapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NavitrackapiApplication.class, args);
	}

}
