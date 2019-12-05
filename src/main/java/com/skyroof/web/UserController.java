package com.skyroof.web;

import com.skyroof.dao.*;
import com.skyroof.model.entities.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDAO userDao;

    @ResponseBody
    @GetMapping("/getAllPersons")
    public List<UsersEntity> getAllUsers() {
        List<UsersEntity> all = (List<UsersEntity>) userDao.findAll();
        return all;
    }

    @GetMapping("/saveUser")
    public void saveUser(){
        UsersEntity newUser = new UsersEntity();
        newUser.setEmail("asdfgg");
        newUser.setPswd("1234");
        newUser.setUsername("evi");
        userDao.save(newUser);
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
