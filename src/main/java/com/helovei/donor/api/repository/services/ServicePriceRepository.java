package com.helovei.donor.api.repository.services;

import com.helovei.donor.api.model.services.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicePriceRepository extends JpaRepository<ServiceEntity, Long> {

    List<ServiceEntity> findByForCitizens(Boolean value);

}
