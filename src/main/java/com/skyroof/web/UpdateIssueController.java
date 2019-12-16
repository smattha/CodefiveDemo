package com.skyroof.web;

import com.skyroof.datatypes.IssueEntityExt;
import com.skyroof.datatypes.IssueImport;
import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class UpdateIssueController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private IssueDAO issueDAO;
    @Autowired
    private ProjectDAO projectDAO;

    IssuesEntity upIssue = new IssuesEntity();
    @PostMapping("/updateIssueRequest")
    public @ResponseBody    int updateIssueR(@RequestBody IssuesEntity issuesEntity) {
        //IssuesEntity upIssue = new IssuesEntity();
        upIssue.setIssueId(issuesEntity.getIssueId());
        upIssue.setAssignor(issuesEntity.getAssignor());
        upIssue.setCreatedBy(issuesEntity.getCreatedBy());
        return upIssue.getIssueId();
    }

    @PostMapping("/updateIssue")
        public @ResponseBody String updateIssueS(@RequestBody IssueEntityExt issueImport){
        IssuesEntity newIssue = issueDAO.findByIssueId(issueImport.getId());//new IssuesEntity();

        if (!issueImport.getTitle().equals(""))
        {
            newIssue.setTitle(issueImport.getTitle());
        }

        if (!issueImport.getDescription().equals(""))
        {
            newIssue.setIssueDescription(issueImport.getDescription());
        }

        if (!issueImport.getType().equals(""))
        {
            newIssue.setIssueType(issueImport.getType());
        }

        if (!issueImport.getOtherDetails().equals(""))
        {
            newIssue.setOtherDetails(issueImport.getOtherDetails());
        }


        if (issueImport.getAssignee()>=0)
        {
            newIssue.setAssignee(issueImport.getAssignee());
        }

        if (issueImport.getStatusId()>=0)
        {
            newIssue.setStatusId(issueImport.getStatusId());
        }

        if (issueImport.getProjectId()>=0)
        {
            newIssue.setProjectId(issueImport.getProjectId());
        }

        issueDAO.save(newIssue);


        return "Issue updated";
        }
}
