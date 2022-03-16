package com.helovei.donor.api.repository.blood;

import com.helovei.donor.api.model.blood.BloodRhEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRhRepository extends JpaRepository<BloodRhEntity, Long> {
}
