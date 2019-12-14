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
public class IssueFilterController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private IssueDAO issueDAO;
    @Autowired
    private ProjectDAO projectDAO;

    @PostMapping("/issueQuery")
    public @ResponseBody List<IssuesEntity> issueQuery(@RequestBody QueryDetails qd){
        List<IssuesEntity> all = issueDAO.findIssuesEntitiesByProjectIdAndTitleContainingAndAssignorAndAssigneeAndIssueTypeContainingAndStatusId(qd.getProjectId(), qd.getTitle(), qd.getAssignor(), qd.getAssignee(), qd.getIssueType(), qd.getStatusId());
        return all;
    }
}
