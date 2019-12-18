package com.skyroof.dao;

import com.skyroof.model.entities.ProjectsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectDAO extends CrudRepository<ProjectsEntity, Integer> {

    @Override
    <S extends ProjectsEntity> S save(S s);

    ProjectsEntity findProjectsEntityByProjectid(int id);
}