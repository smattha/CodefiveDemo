package com.skyroof.web;

import com.skyroof.dao.IssueDAO;
import com.skyroof.model.entities.IssuesEntity;
import com.skyroof.skyroof.SkyroofServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class DeleteIssueController {

    @Autowired
    private IssueDAO issueDAO;

    //Soft-deletes an issue
    @PostMapping("/delete")
    public @ResponseBody
    String deleteIssue(@RequestBody String id) {
        SkyroofServer.logger.info("Entered deleteIssue() with id: " + id);
        IssuesEntity issue = issueDAO.findByIssueId(Integer.parseInt(id));
        issue.setIsHidden((byte) 1);
        issueDAO.save(issue);
        SkyroofServer.logger.info("Exited deleteIssue()");
        if (issue.getIsHidden() == 1) return "Issue deleted.";
        else return "Delete failed";
    }
}
