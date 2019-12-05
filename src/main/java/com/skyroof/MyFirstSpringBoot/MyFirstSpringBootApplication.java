package com.skyroof.MyFirstSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //dilwnei oti einai i arxiki me8odos toy spring boot
@ComponentScan("com.skyroof") //psaxnei olo to project kai briskei annotations ta opoia
//enswmatwnei mesa sto project
public class MyFirstSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringBootApplication.class, args);
	}

}
