package com.skyroof.web;

import com.skyroof.datatypes.LoginDetails;
import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private UserDAO userDao;

    //executes the necessary checks for the login
    @PostMapping("/login")
    public @ResponseBody String login(@RequestBody LoginDetails ld){
        UsersEntity user = userDao.findByUsername(ld.getUsername());

        //first check if there is a user with the username provided
        if (user == null) return "Error occurred during Login";
        System.out.println("User data from db" +user.toString());

        //then check if the passwords match
        if (user.getPswd().equals(ld.getPswd()))
            return "Login Successful!";
        else return "Error occurred during Login";
    }
}
