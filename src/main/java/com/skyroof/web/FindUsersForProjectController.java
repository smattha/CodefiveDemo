package com.skyroof.web;

import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FindUsersForProjectController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private IssueDAO issueDAO;
    @Autowired
    private ProjectDAO projectDAO;

    @PostMapping("/findPeopleForProject")
    public @ResponseBody List<UsersEntity> findUsersForProject(@RequestBody String id){
        List<PermissionEntity> permissionEntities = permissionDAO.findPermissionEntitiesByProjectid(Integer.parseInt(id));
        List<UsersEntity> users = new ArrayList<>();
        for (int index = 0; index < permissionEntities.size(); index++){
            UsersEntity u = userDao.findById(permissionEntities.get(index).getUserid());
            users.add(u);
        }
        return users;
    }
}
