package com.skyroof.web;

import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private IssueDAO issueDAO;

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
    @GetMapping("/saveIssue")
    public void saveIssue(){
        IssuesEntity newIssue = new IssuesEntity();
        newIssue.setAssignee(1);
        newIssue.setAssignor(2);
        newIssue.setIsHidden((byte) 101);
        newIssue.setIssueDescription("Just a description");
        newIssue.setIssueId(5);
        newIssue.setIssueType("type1");
        newIssue.setProjectId(212);
        newIssue.setTitle("big issue");
        newIssue.setStatusId(0);

        issueDAO.save(newIssue);


    }

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

    @GetMapping("/issueQuery")
    public List<IssuesEntity> issueQuery(){
        List<IssuesEntity> all = issueDAO.findIssuesEntitiesByProjectIdAndTitleContainingAndAssignorAndAssigneeAndIssueTypeContainingAndStatusId(1, "", 1, 3, "", 1);
        return all;
    }

    @PostMapping("/savenewIssue")
    public @ResponseBody IssuesEntity  savenewissue(@RequestBody IssuesEntity issuesEntity) {
        System.out.println(issuesEntity.toString());
        IssuesEntity save = issueDAO.save(issuesEntity);
        return save;
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
