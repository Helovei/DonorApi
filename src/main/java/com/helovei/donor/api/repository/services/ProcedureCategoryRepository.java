package com.helovei.donor.api.repository.services;

import com.helovei.donor.api.model.services.ProcedureCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureCategoryRepository extends JpaRepository<ProcedureCategory, Long> {

}
