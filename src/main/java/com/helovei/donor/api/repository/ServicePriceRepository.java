package com.helovei.donor.api.repository;

import com.helovei.donor.api.model.ServicePriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePriceRepository extends JpaRepository<ServicePriceEntity, Long> {
}
