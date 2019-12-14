package com.skyroof.web;

import com.skyroof.exceptions.NoProjectsFoundException;
import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private IssueDAO issueDAO;
    @Autowired
    private ProjectDAO projectDAO;

    @PostMapping("/login")
    public @ResponseBody String login(@RequestBody LoginDetails ld){
        System.out.println(ld.toString());
        UsersEntity user = userDao.findByUsername(ld.getUsername());
        if (user == null) return "Error occurred during Login";
        System.out.println("User data from db" +user.toString());
        //else System.out.println(user.toString());
        if (user.getPswd().equals(ld.getPswd()))
            return "Login Successful!";
        else return "Error occurred during Login";
    }
}
