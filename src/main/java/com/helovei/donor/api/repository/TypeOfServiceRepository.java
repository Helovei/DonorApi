package com.helovei.donor.api.repository;

import com.helovei.donor.api.model.TypeOfServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfServiceRepository extends JpaRepository<TypeOfServiceEntity, Long> {
}
