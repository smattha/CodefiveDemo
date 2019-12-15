package com.skyroof.web;

import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class DeleteIssueController {

    @Autowired
    private IssueDAO issueDAO;

    //Soft-deletes an issue
    @PostMapping("/delete")
    public @ResponseBody String deleteIssue(@RequestBody String id){
        IssuesEntity issue = issueDAO.findByIssueId(Integer.parseInt(id));
        issue.setIsHidden((byte) 1);
        issueDAO.save(issue);
        if (issue.getIsHidden()==1) return "Issue deleted.";
        else return "Delete failed";
    }
}
