package com.skyroof.dao;

import com.skyroof.model.entities.IssuesEntity;
import com.skyroof.model.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

@Repository
public interface IssueDAO extends CrudRepository<IssuesEntity, Integer> {
    @Override
    List<IssuesEntity> findAll();

    @Override
    <S extends IssuesEntity> S save(S s);

    List<IssuesEntity> findIssuesEntitiesByProjectIdAndTitleContainingAndAssignorAndAssigneeAndIssueTypeContainingAndStatusId(Integer projectId, String title, Integer assignor, Integer assignee, String issueType, Integer statusId);



}
