package com.skyroof.web;

import com.skyroof.datatypes.IssueObject;
import com.skyroof.datatypes.QueryDetails;
import com.skyroof.datatypes.UserProjects;
import com.skyroof.exceptions.NoProjectsFoundException;
import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
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
        List<UsersEntity> all = (List<UsersEntity>) userDao.findAll();
        return all;
    }

    @PostMapping("/findProjectsForUser")
    public @ResponseBody
    List<UserProjects> findProjects(@RequestBody String username) {
        System.out.println("Username " + username);
        UsersEntity user = userDao.findByUsername(username);
        List<PermissionEntity> permissions = permissionDAO.findPermissionEntitiesByUserid(user.getUserid());
        List<UserProjects> userProjects = new ArrayList<>();

        for (int index = 0; index < permissions.size(); index++) {
            UserProjects up = new UserProjects();
            ProjectsEntity project = projectDAO.findProjectsEntityByProjectid(permissions.get(index).getProjectid());
            up.setProjectId(project.getProjectid());
            up.setProjectName(project.getProjectName());
            up.setPermission(permissions.get(index).getPermissionDescription());
            userProjects.add(up);
        }
        if (userProjects.size() == 0) throw new NoProjectsFoundException();
        return userProjects;
    }

    @PostMapping("/showOpenIssues")
    public @ResponseBody
    List<IssueObject> showOpenIssues(@RequestBody String username) {
        List<UserProjects> userProjects = findProjects(username);
        List<IssueObject> openIssues = new ArrayList<>();
        for (int index = 0; index < userProjects.size(); index++) {
            List<IssuesEntity> issues = issueDAO.findIssuesEntitiesByProjectId(userProjects.get(index).getProjectId());
            for (int index2 = 0; index2 < issues.size(); index2++) {
                if (issues.get(index2).getStatusId() == 1) {
                    IssueObject oi = new IssueObject();
                    oi.setProjectTitle(userProjects.get(index).getProjectName());
                    oi.setIssueTitle(issues.get(index2).getTitle());
                    UsersEntity user = userDao.findById(issues.get(index2).getAssignor());
                    oi.setAssignor(user.getUsername());
                    oi.setStatus(issues.get(index2).getStatusId());
                    oi.setType(issues.get(index2).getIssueType());
                    oi.setIssueId(issues.get(index2).getIssueId());
                    oi.setPermission(userProjects.get(index).getPermission());
                    openIssues.add(oi);
                }
            }
        }
        return openIssues;
    }

    @PostMapping("/showUserOpenIssue")
    public @ResponseBody
    List<IssueObject> showUserOpenIssues(@RequestBody String username) {
        List<IssueObject> allOpenIssues = showOpenIssues(username);
        List<IssueObject> UserOpenIssues = new ArrayList<>();
        for (int index = 0; index < allOpenIssues.size(); index++) {
            if (allOpenIssues.get(index).getAssignor().equals(username))
                UserOpenIssues.add(allOpenIssues.get(index));
        }
        return UserOpenIssues;
    }

    @PostMapping("/issueQuery")
    public @ResponseBody
    List<IssueObject> issueQuery(@RequestBody QueryDetails qd) {
        List<UserProjects> userProjects = findProjects(qd.getUsername());
        List<IssueObject> openIssues = new ArrayList<>();
        for (int index = 0; index < userProjects.size(); index++) {
            if (userProjects.get(index).getProjectId() == qd.getProjectId()) {
                System.out.println(userProjects.get(index).toString());
                List<IssuesEntity> issues = issueDAO.findIssuesEntitiesByProjectIdAndTitleContainingAndAssignorAndAssigneeAndIssueTypeContainingAndStatusId(qd.getProjectId(), qd.getTitle(), qd.getAssignor(), qd.getAssignee(), qd.getIssueType(), qd.getStatusId());
                if (issues.size() != 0) {
                    for (int index2 = 0; index2 < issues.size(); index2++) {
                        IssuesEntity issue = issues.get(index2);
                        System.out.println(issue.toString());
                        IssueObject oi = new IssueObject();
                        oi.setProjectTitle(userProjects.get(index).getProjectName());
                        oi.setIssueTitle(issues.get(index2).getTitle());
                        UsersEntity user = userDao.findById(issues.get(index2).getAssignor());
                        oi.setAssignor(user.getUsername());
                        oi.setStatus(issues.get(index2).getStatusId());
                        oi.setType(issues.get(index2).getIssueType());
                        oi.setIssueId(issues.get(index2).getIssueId());
                        oi.setPermission(userProjects.get(index).getPermission());
                        openIssues.add(oi);
                    }
                }
            }
        }
        return openIssues;
    }


//        List<IssuesEntity> issuesEntities = issueDAO.findIssuesEntitiesByProjectIdAndTitleContainingAndAssignorAndAssigneeAndIssueTypeContainingAndStatusId(qd.getProjectId(), qd.getTitle(), qd.getAssignor(), qd.getAssignee(), qd.getIssueType(), qd.getStatusId());
//        List<IssueObject> issues = new ArrayList<>();
//
//        return all;
//    }
//}


//    @GetMapping("/saveIssue")
//    public void saveIssue(){
//        IssuesEntity newIssue = new IssuesEntity();
//        newIssue.setAssignee(1);
//        newIssue.setAssignor(2);
//        newIssue.setIsHidden((byte) 0);
//        newIssue.setIssueDescription("Just a descr");
//        //newIssue.setIssueId(15);
//        newIssue.setIssueType("error");
//        newIssue.setProjectId(2);
//        newIssue.setTitle("big issue");
//        newIssue.setStatusId(1);
//        newIssue.setCreatedBy("xristos");
//
//        issueDAO.save(newIssue);
//
//
//    }

//    @GetMapping("/firstQuery")
//    public UsersEntity firstQuery(){
//        Optional<UsersEntity> user = userDao.findById(1);
//        return user.get();
//        //HashMap<Integer, UsersEntity> all = (HashMap<Integer, UsersEntity>) userDao.findByIdLike(1).orElse(null);
//        //return all;
//    }


//        for (int index = 0; index < userProjects.size(); index++){
//            List<IssuesEntity> issues = issueDAO.findIssuesEntitiesByProjectId(userProjects.get(index).getProjectId());
//            for (int index2 = 0; index2 < issues.size(); index2++){
//                if(issues.get(index2).getStatusId() == 1){
//                    if(loggedInUser.getUserid()==issues.get(index2).getAssignor()){
//                        UsersEntity user = userDao.findById(issues.get(index2).getAssignor());
//                        OpenIssue oi = new OpenIssue();
//                        oi.setProjectTitle(userProjects.get(index).getProjectName());
//                        oi.setIssueTitle(issues.get(index2).getTitle());
//                        oi.setAssignor(user.getUsername());
//                        oi.setStatus(issues.get(index2).getStatusId());
//                        oi.setType(issues.get(index2).getIssueType());
//                        UserOpenIssues.add(oi);
//                    }
//                }
//            }
//        }


//  if assignor === sdfh && assignee ==  && ->
    // List<UsersEntity> filtered = (List<UsersEntity>) userDao.filter("filtra,,,,)
    //return filtered;
//    @ResponseBody
//    @GetMapping("/getById/{id}")
//    public Person getById(@PathVariable("id") Long personId) {
//        Optional<Person> onePerson = userDao.findById(personId);
//
//        return onePerson.get();
//    }
//
//    @ResponseBody
//    @PutMapping("/addnewperson")
//    public Person addnewperson(@RequestBody Person per) {
//        System.out.println(per.toString());
//        Person save = userDao.save(per);
//        return save;
//    }
//
//    @ResponseBody
//    @DeleteMapping("/deletePerson/{id}")
//    public void addnewperson(@PathVariable("id") Long personId) {
//        userDao.deleteById(personId);
//    }

}
