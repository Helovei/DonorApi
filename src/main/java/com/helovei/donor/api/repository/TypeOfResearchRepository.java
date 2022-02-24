package com.helovei.donor.api.repository;

import com.helovei.donor.api.model.TypeOfResearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfResearchRepository extends JpaRepository<TypeOfResearchEntity, Long> {
}
