package com.skyroof.web;

import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IssuesController {

    @Autowired
    private IssueDAO issueDAO;


    //returns all issues
    @GetMapping("/getIssues")
    public List<IssuesEntity> getAllIssues() {
        return issueDAO.findAll();
    }

    //finds an issue by its id
    @RequestMapping("/Issue")
    public @ResponseBody IssuesEntity getIssue(@RequestBody String id){
        return issueDAO.findByIssueId(Integer.parseInt(id));
    }

}
