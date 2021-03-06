package com.skyroof.web;

import com.skyroof.dao.IssueDAO;
import com.skyroof.datatypes.IssueImport;
import com.skyroof.model.entities.IssuesEntity;
import com.skyroof.skyroof.SkyroofServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CreateIssueController {

    @Autowired
    private IssueDAO issueDAO;


    //Creates a new Issue entry in the database
    @PostMapping("/createIssue")
    public void createIssue(@RequestBody IssueImport issueImport) {
        SkyroofServer.logger.info("Entered createIssue() with details: " + issueImport.toString());
        IssuesEntity newIssue = new IssuesEntity(issueImport.getTitle(), issueImport.getDescription(), issueImport.getType(), issueImport.getOtherDetails(), (byte) 0, issueImport.getProjectId(), issueImport.getStatusId(), issueImport.getAssignor(), issueImport.getAssignee(), issueImport.getUsername());
        SkyroofServer.logger.info("Exited createIssue(). The created issue is: " + newIssue.toString());
        issueDAO.save(newIssue);
    }
}
