package com.skyroof.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.util.logging.Logger;

@RestController //
public class HelloWorld {
    @RequestMapping("/") //zitame to resource poy brisketai katw apo to "/" (diladi t0 localhost:8081/)
    public String index() {


        return "Hello World";
    }

}
