package com.skyroof.dao;

import com.skyroof.model.entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDAO extends  CrudRepository<UsersEntity, Integer> {
    @Override
    List<UsersEntity> findAll();
    //List<UsersEntity> findByIdLike(int id);
    //List<UsersEntity> findByDateOfBirthGreaterThan(Date date);

//    @Override
//    <S extends Person> S save(S s);
//
//    @Override
//    void deleteById(Long aLong);
}