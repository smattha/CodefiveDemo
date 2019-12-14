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
public class DeleteIssueController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private IssueDAO issueDAO;
    @Autowired
    private ProjectDAO projectDAO;

    @PostMapping("/delete")
    public @ResponseBody String deleteIssue(@RequestBody String id){
        IssuesEntity issue = issueDAO.findByIssueId(Integer.parseInt(id));
        System.out.println(issue.toString());
        issue.setIsHidden((byte) 1);
        System.out.println(issue.toString());
        issueDAO.save(issue);
        if (issue.getIsHidden()==1) return "Issue deleted.";
        else return "Delete failed";
    }
}
