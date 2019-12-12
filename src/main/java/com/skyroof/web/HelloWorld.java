package com.skyroof.web;

import ch.qos.logback.classic.BasicConfigurator;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.util.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController //
public class HelloWorld {
    @RequestMapping("/") //zitame to resource poy brisketai katw apo to "/" (diladi t0 localhost:8081/)
    public String index(){




        return "Hello World";
    }

}
