package com.skyroof.skyroof;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
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

public class SkyroofServer {
    public static final Logger logger = Logger.getLogger("logger");

    public static void main(String[] args) {
        logger.info("Skyroof server started");
        logger.setLevel(Level.ALL);
        SpringApplication.run(SkyroofServer.class, args);

    }

}
