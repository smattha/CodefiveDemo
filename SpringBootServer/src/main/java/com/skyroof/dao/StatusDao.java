package com.skyroof.dao;

import com.skyroof.model.entities.IssuestatusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StatusDao extends CrudRepository<IssuestatusEntity, Integer> {
    @Override
    List<IssuestatusEntity> findAll();
    //HashMap<Integer, UsersEntity> findByIdLike(int userId);


//
//    @Override
//    void deleteById(Long aLong);
}