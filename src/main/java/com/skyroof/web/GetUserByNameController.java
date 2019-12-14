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
public class GetUserByNameController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private IssueDAO issueDAO;
    @Autowired
    private ProjectDAO projectDAO;

    @GetMapping("/getByName")
    public List<UsersEntity> getByName(){
        //public List<UsersEntity> userDao.findByName("%e%");
        List<UsersEntity> all = userDao.findUsersEntitiesByUsernameContainingAndEmailContaining("e", "");
        return all;
    }

}
