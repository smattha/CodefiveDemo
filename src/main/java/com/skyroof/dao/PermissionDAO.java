package com.skyroof.dao;
import com.skyroof.model.entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PermissionDAO extends CrudRepository<PermissionEntity, Integer> {

//    @Override
//    <S extends PermissionEntity> S save(S s);

    List<PermissionEntity> findPermissionEntitiesByUserid(int id);
    List<PermissionEntity> findPermissionEntitiesByProjectid(int id);
}