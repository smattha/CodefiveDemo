package com.skyroof.dao;
import com.skyroof.model.entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProjectDAO extends CrudRepository<ProjectsEntity, Integer> {

    @Override
    <S extends ProjectsEntity> S save(S s);
}