package com.skyroof.web;

import com.skyroof.datatypes.IssueEnt;
import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import com.skyroof.skyroof.SkyroofServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IssuesController {

    @Autowired
    private IssueDAO issueDAO;
    @Autowired
    private UserDAO userDAO;


    //returns all issues
    @GetMapping("/getIssues")
    public List<IssuesEntity> getAllIssues() {
        return issueDAO.findAll();
    }

    //finds an issue by its id
    @RequestMapping("/Issue")
    public @ResponseBody IssueEnt getIssue(@RequestBody String id){
        SkyroofServer.logger.info("Entered getIssue() with id" + id);
        IssuesEntity issue = issueDAO.findByIssueId(Integer.parseInt(id));
        UsersEntity assignor = userDAO.findById(issue.getAssignor());
        UsersEntity assignee = userDAO.findById(issue.getAssignee());
        IssueEnt issueEnt = new IssueEnt(issue.getIssueId(), issue.getTitle(), issue.getIssueDescription(), issue.getIssueType(), issue.getOtherDetails(), issue.getIsHidden(), issue.getProjectId(), issue.getStatusId(), assignor.getUsername(), assignee.getUsername(), issue.getCreatedBy());
        SkyroofServer.logger.info("Exited getIssue() with issue" + issueEnt.toString());
        return issueEnt;
    }
}