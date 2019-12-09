package com.skyroof.dao;

import com.skyroof.model.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public interface UserDAO extends  CrudRepository<UsersEntity, Integer> {
    @Override
    List<UsersEntity> findAll();
    //HashMap<Integer, UsersEntity> findByIdLike(int userId);
    List<UsersEntity> findById(int id);
    //List<UsersEntity> findByDateOfBirthGreaterThan(Date date);

    List<UsersEntity> findUsersEntitiesByUsernameContainingAndEmailContaining(String username, String email);

    @Override
    <S extends UsersEntity> S save(S s);

//
//    @Override
//    void deleteById(Long aLong);
}