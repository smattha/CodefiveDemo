package com.skyroof.web;

import com.skyroof.datatypes.IssueImport;
import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CreateIssueController {

    @Autowired
    private IssueDAO issueDAO;

    //Creates a new Issue entry in the database
    @PostMapping("/createIssue")
    public void createIssue(@RequestBody IssueImport issueImport) {
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
    }
}
