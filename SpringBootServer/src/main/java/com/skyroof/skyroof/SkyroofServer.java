package com.skyroof.skyroof;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.skyroof")
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
