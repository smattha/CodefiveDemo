package com.skyroof.web;

import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import com.skyroof.skyroof.SkyroofServer;
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

    //find all the users with permission to a certain project
    @PostMapping("/findPeopleForProject")
    public @ResponseBody List<UsersEntity> findUsersForProject(@RequestBody String id){
        SkyroofServer.logger.info("Entered findUsersForProject() with id" + id);
        //create a list with all the permission entries for a certain project
        List<PermissionEntity> permissionEntities = permissionDAO.findPermissionEntitiesByProjectid(Integer.parseInt(id));
        List<UsersEntity> users = new ArrayList<>();
        //for each permission entry find the user it refers to
        //save this user in the users List
        for (PermissionEntity permissionEntity : permissionEntities) {
            UsersEntity u = userDao.findById(permissionEntity.getUserid());
            SkyroofServer.logger.info("User found: " + u.toString());
            users.add(u);
        }
        SkyroofServer.logger.info("Exited findUsersForProject()");
        return users;
    }
}
