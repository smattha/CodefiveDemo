package com.skyroof.dao;

import com.skyroof.model.entities.PermissionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PermissionDAO extends CrudRepository<PermissionEntity, Integer> {

//    @Override
//    <S extends PermissionEntity> S save(S s);

    List<PermissionEntity> findPermissionEntitiesByUserid(int id);

    List<PermissionEntity> findPermissionEntitiesByProjectid(int id);
}