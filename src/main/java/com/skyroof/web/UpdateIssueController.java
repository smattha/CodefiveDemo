package com.skyroof.web;

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

    @PostMapping("/updateIssueSave")
        public @ResponseBody String updateIssueS(@RequestBody IssueImport issueImport){
        IssuesEntity newIssue = new IssuesEntity();
        //Kratav idies tis times issueId kai Assignor apo thn updateIssueRequest
        newIssue.setIssueId(upIssue.getIssueId());
        newIssue.setAssignor(upIssue.getAssignor());
        newIssue.setCreatedBy(upIssue.getCreatedBy());

        newIssue.setTitle(issueImport.getTitle());
        newIssue.setIssueDescription(issueImport.getDescription());
        newIssue.setIssueType(issueImport.getType());
        newIssue.setOtherDetails(issueImport.getOtherDetails());
        newIssue.setAssignee(issueImport.getAssignee());
        newIssue.setStatusId(issueImport.getStatusId());
        newIssue.setProjectId(issueImport.getProjectId());
        newIssue.setIsHidden((byte) 0);

        issueDAO.save(newIssue);


        return "Issue updated";
        }
}
