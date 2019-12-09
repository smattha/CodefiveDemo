package com.skyroof.web;

import com.skyroof.model.entities.*;
import com.skyroof.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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



      @PostMapping("/savenewIssue")
    public @ResponseBody IssuesEntity  savenewissue(@RequestBody IssuesEntity issuesEntity) {
        System.out.println(issuesEntity.toString());
        IssuesEntity save = issueDAO.save(issuesEntity);
        return save;
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
