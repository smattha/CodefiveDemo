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
public class CreateIssueController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private IssueDAO issueDAO;
    @Autowired
    private ProjectDAO projectDAO;

    @PostMapping("/createIssue")
    public @ResponseBody String createIssue(@RequestBody IssueImport issueImport) {
        IssuesEntity newIssue = new IssuesEntity();
        newIssue.setTitle(issueImport.getTitle());
        newIssue.setIssueDescription(issueImport.getDescription());
        newIssue.setIssueType(issueImport.getType());
        newIssue.setOtherDetails(issueImport.getOtherDetails());
        newIssue.setAssignor(issueImport.getAssignor());
        newIssue.setAssignee(issueImport.getAssignee());
        newIssue.setStatusId(issueImport.getStatusId());
        newIssue.setProjectId(issueImport.getProjectId());
        newIssue.setCreatedBy(issueImport.getUsername());
        newIssue.setIsHidden((byte) 0);
        issueDAO.save(newIssue);
        //System.out.println(newIssue.toString());
        return "Issue created";
    }
}
