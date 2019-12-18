package com.skyroof.dao;

import com.skyroof.model.entities.IssuesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueDAO extends CrudRepository<IssuesEntity, Integer> {
    @Override
    List<IssuesEntity> findAll();

    @Override
    <S extends IssuesEntity> S save(S s);

    IssuesEntity findByIssueId(int id);

    List<IssuesEntity> findIssuesEntitiesByProjectId(int id);

    List<IssuesEntity> findIssuesEntitiesByTitleContainingAndAssignorAndAssigneeAndIssueTypeContainingAndStatusIdAndIsHidden(String title, Integer assignor, Integer assignee, String issueType, Integer statusId, byte isHidden);


}
