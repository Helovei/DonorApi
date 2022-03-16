package com.helovei.donor.api.repository.blood;

import com.helovei.donor.api.model.blood.BloodRhEntity;
import com.helovei.donor.api.model.blood.BloodStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodStatusRepository extends JpaRepository<BloodStatusEntity, Long> {

    BloodStatusEntity findDistinctFirstByrH(BloodRhEntity rh);

}
