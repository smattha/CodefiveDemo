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

    @GetMapping("/saveUser")
    public void saveUser(){
        UsersEntity newUser = new UsersEntity();
        newUser.setEmail("asd@mail.com");
        newUser.setPswd("1234");
        newUser.setUsername("chr");
        userDao.save(newUser);
    }
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

    @GetMapping("/getAllIssues")
    public List<IssuesEntity> getAllIssues() {
        List<IssuesEntity> all = (List<IssuesEntity>) issueDAO.findAll();
        return all;
    }

//    @GetMapping("/firstQuery")
//    public UsersEntity firstQuery(){
//        Optional<UsersEntity> user = userDao.findById(1);
//        return user.get();
//        //HashMap<Integer, UsersEntity> all = (HashMap<Integer, UsersEntity>) userDao.findByIdLike(1).orElse(null);
//        //return all;
//    }

    @GetMapping("/getByName")
    public List<UsersEntity> getByName(){
        //public List<UsersEntity> userDao.findByName("%e%");
        List<UsersEntity> all = userDao.findUsersEntitiesByUsernameContainingAndEmailContaining("e", "");
        return all;
    }

    @PostMapping("/issueQuery")
    public @ResponseBody List<IssuesEntity> issueQuery(@RequestBody QueryDetails qd){
        List<IssuesEntity> all = issueDAO.findIssuesEntitiesByProjectIdAndTitleContainingAndAssignorAndAssigneeAndIssueTypeContainingAndStatusId(qd.getProjectId(), qd.getTitle(), qd.getAssignor(), qd.getAssignee(), qd.getIssueType(), qd.getStatusId());
        return all;
    }

    @PostMapping("/createIssue")
    public @ResponseBody String createIssue(@RequestBody IssueImport issueImport) {
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
        //System.out.println(newIssue.toString());
        return "Issue created";
    }

    @PostMapping("/login")
    public @ResponseBody String login(@RequestBody LoginDetails ld){
        System.out.println(ld.toString());
        UsersEntity user = userDao.findByUsername(ld.getUsername());
        if (user == null) return "Error occurred during Login";
        System.out.println("User data from db" +user.toString());
        //else System.out.println(user.toString());
        if (user.getPswd().equals(ld.getPswd()))
        return "Login Successful!";
        else return "Error occurred during Login";
    }

        @PostMapping("/findProjectsForUser")
    public @ResponseBody List<UserProjects> findProjects(@RequestBody String username){
        System.out.println("Username "+ username);
        UsersEntity user = userDao.findByUsername(username);
        List<PermissionEntity> all = permissionDAO.findPermissionEntitiesByUserid(user.getUserid());
        List<UserProjects> userProjects = new ArrayList<>();

        for(int index = 0; index < all.size(); index++){
            UserProjects up = new UserProjects();
            ProjectsEntity project = projectDAO.findProjectsEntityByProjectid(all.get(index).getProjectid());
            up.setProjectId(project.getProjectid());
            up.setProjectName(project.getProjectName());
            up.setPermission(all.get(index).getPermissionDescription());
            userProjects.add(up);
        }
        if (userProjects.size()==0) throw new NoProjectsFoundException();
        return userProjects;
    }

    @PostMapping("/findPeopleForProject")
    public @ResponseBody List<UsersEntity> findUsersForProject(@RequestBody UserId ud){
        List<PermissionEntity> permissionEntities = permissionDAO.findPermissionEntitiesByProjectid(ud.getId());
        List<UsersEntity> users = new ArrayList<>();
        for (int index = 0; index < permissionEntities.size(); index++){
            UsersEntity u = userDao.findById(permissionEntities.get(index).getUserid());
            users.add(u);
        }
        return users;
    }

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
