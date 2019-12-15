package com.skyroof.web;

import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IssuesController {
    @Autowired
    private IssueDAO issueDAO;


    @GetMapping("/getIssues")
    public List<IssuesEntity> getAllIssues() {
        List<IssuesEntity> all = (List<IssuesEntity>) issueDAO.findAll();
        return all;
    }

    @RequestMapping("Issue")
    public @ResponseBody IssuesEntity getIssue(@RequestBody String id){
        IssuesEntity issue = issueDAO.findByIssueId(Integer.parseInt(id));
        return issue;
    }

}
