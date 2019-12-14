package com.skyroof.web;

import com.skyroof.exceptions.NoProjectsFoundException;
import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class SaveUserController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private IssueDAO issueDAO;
    @Autowired
    private ProjectDAO projectDAO;

    @GetMapping("/saveUser")
    public void saveUser(){
        UsersEntity newUser = new UsersEntity();
        newUser.setEmail("asd@mail.com");
        newUser.setPswd("1234");
        newUser.setUsername("chr");
        userDao.save(newUser);
    }
}
