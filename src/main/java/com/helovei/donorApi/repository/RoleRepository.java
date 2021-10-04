package com.helovei.donorApi.repository;

import com.helovei.donorApi.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findRoleEntityByName(String name);

}
