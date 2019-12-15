package com.skyroof.web;

import com.skyroof.skyroof.SkyroofServer;
import com.skyroof.dao.*;
import com.skyroof.model.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class StateController {

    @Autowired
    private StatusDao statusDao;

    //returns all the Status entries of the IssueStatus table
    @ResponseBody
    @GetMapping("/getStatus")
    public List<IssuestatusEntity> getStates() {
        SkyroofServer.logger.info("Skyroof microservice get states was called");
        List<IssuestatusEntity> all = statusDao.findAll();
        SkyroofServer.logger.info(all.toString());
        SkyroofServer.logger.info("Skyroof microservice is about to return");
        return all;
    }

}
