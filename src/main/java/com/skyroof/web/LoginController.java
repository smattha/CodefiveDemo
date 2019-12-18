package com.skyroof.web;

import com.skyroof.dao.UserDAO;
import com.skyroof.datatypes.LoginDetails;
import com.skyroof.model.entities.UsersEntity;
import com.skyroof.skyroof.SkyroofServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private UserDAO userDao;

    //executes the necessary checks for the login
    @PostMapping("/login")
    public @ResponseBody
    String login(@RequestBody LoginDetails ld) {
        SkyroofServer.logger.info("Entered login() with login details " + ld.toString());
        UsersEntity user = userDao.findByUsername(ld.getUsername());

        //first check if there is a user with the username provided
        if (user == null) {
            SkyroofServer.logger.info("Exited login() with error: User not found");
            return "Error occurred during Login";
        }
        System.out.println("User data from db" + user.toString());

        //then check if the passwords match
        if (user.getPswd().equals(ld.getPswd())) {
            SkyroofServer.logger.info("Exited login() successfully");
            return "Login Successful!";
        }
        SkyroofServer.logger.info("Exited login() with error: Password don't much");
        return "Error occurred during Login";
    }
}
