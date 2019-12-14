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

    @PostMapping("/showOpenIssues")
    public @ResponseBody List<OpenIssue> showOpenIssues(@RequestBody String username){
        List<UserProjects> userProjects = findProjects(username);
        List<OpenIssue> openIssues = new ArrayList<>();
        for (int index = 0; index < userProjects.size(); index++){
            List<IssuesEntity> issues = issueDAO.findIssuesEntitiesByProjectId(userProjects.get(index).getProjectId());
            for (int index2 = 0; index2 < issues.size(); index2++){
                if(issues.get(index2).getStatusId() == 1){
                    OpenIssue oi = new OpenIssue();
                    oi.setProjectTitle(userProjects.get(index).getProjectName());
                    oi.setIssueTitle(issues.get(index2).getTitle());
                    UsersEntity user = userDao.findById(issues.get(index2).getAssignor());
                    oi.setAssignor(user.getUsername());
                    oi.setStatus(issues.get(index2).getStatusId());
                    oi.setType(issues.get(index2).getIssueType());
                    openIssues.add(oi);
                }
            }
        }
        return openIssues;
    }

    @PostMapping("/showUserOpenIssue")
    public @ResponseBody List<OpenIssue> showUserOpenIssues(@RequestBody String username){
        List<OpenIssue> allOpenIssues = showOpenIssues(username);
        List<OpenIssue> UserOpenIssues = new ArrayList<>();
        for (int index = 0; index < allOpenIssues.size(); index++){
            if(allOpenIssues.get(index).getAssignor().equals(username))
                UserOpenIssues.add(allOpenIssues.get(index));
        }
        return UserOpenIssues;
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
