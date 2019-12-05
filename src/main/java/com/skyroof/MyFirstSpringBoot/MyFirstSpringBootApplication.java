package com.skyroof.MyFirstSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //dilwnei oti einai i arxiki me8odos toy spring boot
@ComponentScan("com.skyroof") //psaxnei olo to project kai briskei annotations ta opoia
//enswmatwnei mesa sto project
@EntityScan("com.skyroof")
@EnableJpaRepositories("com.skyroof")
public class MyFirstSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringBootApplication.class, args);
	}

}
