package com.skyroof.web;

import com.skyroof.dao.IssueDAO;
import com.skyroof.dao.PermissionDAO;
import com.skyroof.dao.ProjectDAO;
import com.skyroof.dao.UserDAO;
import com.skyroof.datatypes.IssueObject;
import com.skyroof.datatypes.QueryDetails;
import com.skyroof.datatypes.UserProjects;
import com.skyroof.exceptions.NoProjectsFoundException;
import com.skyroof.model.entities.IssuesEntity;
import com.skyroof.model.entities.PermissionEntity;
import com.skyroof.model.entities.ProjectsEntity;
import com.skyroof.model.entities.UsersEntity;
import com.skyroof.skyroof.SkyroofServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private IssueDAO issueDAO;
    @Autowired
    private ProjectDAO projectDAO;

    @ResponseBody
    @GetMapping("/getAllPersons")
    public List<UsersEntity> getAllUsers() {
        return userDao.findAll();
    }

    //returns all projects that a user has permission in along with the type of the permission
    @PostMapping("/findProjectsForUser")
    public @ResponseBody
    List<UserProjects> findProjects(@RequestBody String username) {
        SkyroofServer.logger.info("Entered findProjects() with username: " + username);
        //Find the user by his username, then find the user's permissions
        UsersEntity user = userDao.findByUsername(username);
        List<PermissionEntity> permissions = permissionDAO.findPermissionEntitiesByUserid(user.getUserid());
        List<UserProjects> userProjects = new ArrayList<>();

        //for each permission, find the project it refers to to and save it in the userProjects list
        for (PermissionEntity permission : permissions) {

            ProjectsEntity project = projectDAO.findProjectsEntityByProjectid(permission.getProjectid());
            UserProjects up = new UserProjects(project.getProjectid(), project.getProjectName(), permission.getPermissionDescription());
            SkyroofServer.logger.info("Project found: " + up.toString());
            userProjects.add(up);
        }
        if (userProjects.size() == 0) throw new NoProjectsFoundException();
        SkyroofServer.logger.info("Exited findProjects()");
        return userProjects;
    }


    //return all open issues
    @PostMapping("/showOpenIssues")
    public @ResponseBody
    List<IssueObject> showOpenIssues(@RequestBody String username) {

        //Get all projects the user has permissions in
        SkyroofServer.logger.info("Entered showOpenIssues() with username: " + username);
        List<UserProjects> userProjects = findProjects(username);
        List<IssueObject> openIssues = new ArrayList<>();
        //Find all the available issues for each of the projects
        for (UserProjects userProject : userProjects) {
            List<IssuesEntity> issues = issueDAO.findIssuesEntitiesByProjectId(userProject.getProjectId());
            for (IssuesEntity issue : issues) {

                //Check the status of each issue
                //If the status is 1(meaning open), save the issue in the openIssue List
                if ((issue.getStatusId() == 1) && (issue.getIsHidden() == 0)) {
                    UsersEntity user = userDao.findById(issue.getAssignor());
                    IssueObject oi = new IssueObject(userProject.getProjectName(), issue.getTitle(), user.getUsername(), issue.getStatusId(), issue.getIssueType(), userProject.getPermission(), issue.getIssueId());
                    SkyroofServer.logger.info("Open Issue found: " + oi.toString());
                    openIssues.add(oi);
                }
            }
        }
        SkyroofServer.logger.info("Exited ShowOpenIssues()");
        return openIssues;
    }

    //returns all issues where the user is the assignor
    @PostMapping("/showUserOpenIssue")
    public @ResponseBody
    List<IssueObject> showUserOpenIssues(@RequestBody String username) {

        //get all open issues
        SkyroofServer.logger.info("Entered showUserOpenIssues() with username: " + username);
        List<IssueObject> allOpenIssues = showOpenIssues(username);
        List<IssueObject> UserOpenIssues = new ArrayList<>();

        //if the logged in user is also the assignor for an issue, save the issue in the UserOpenIssue list
        for (IssueObject openIssue : allOpenIssues) {
            if (openIssue.getAssignor().equals(username))
                SkyroofServer.logger.info("User-opened issue found: " + openIssue.toString());
            UserOpenIssues.add(openIssue);
        }
        SkyroofServer.logger.info("Exited showUserOpenIssues()");
        return UserOpenIssues;
    }

    //returns all issues that match a specific query
    @PostMapping("/issueQuery")
    public @ResponseBody
    List<IssueObject> issueQuery(@RequestBody QueryDetails qd) {

        //Get all projects the user has permissions in
        SkyroofServer.logger.info("Entered issueQuery() with query details: " + qd.toString());
        List<UserProjects> userProjects = findProjects(qd.getUsername());
        List<IssueObject> openIssues = new ArrayList<>();
        //Go through all the projects and find the one whose id matches the id given in the query
        for (UserProjects userProject : userProjects) {
            if (userProject.getProjectId() == qd.getProjectId()) {
                System.out.println(userProject.toString());

                //Make a list of all the issues that match the query
                List<IssuesEntity> issues = issueDAO.findIssuesEntitiesByTitleContainingAndAssignorAndAssigneeAndIssueTypeContainingAndStatusIdAndIsHidden(qd.getTitle(), qd.getAssignor(), qd.getAssignee(), qd.getIssueType(), qd.getStatusId(), (byte) 0);
                if ((issues.size() != 0)) {
                    //for every issue that matches the query, create a new IssueObject and save it to the openIssues list
                    for (IssuesEntity issue : issues) {
                        //System.out.println(issue.toString());
                        UsersEntity user = userDao.findById(issue.getAssignor());
                        IssueObject oi = new IssueObject(userProject.getProjectName(), issue.getTitle(), user.getUsername(), issue.getStatusId(), issue.getIssueType(), userProject.getPermission(), issue.getIssueId());
                        SkyroofServer.logger.info("Found and issue that matches the query: " + oi.toString());
                        openIssues.add(oi);
                    }
                }
            }
        }
        SkyroofServer.logger.info("Exited issueQuery()");
        return openIssues;
    }
}