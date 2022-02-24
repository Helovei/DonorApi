package com.helovei.donor.api.repository;

import com.helovei.donor.api.model.WebsiteCategory;
import com.helovei.donor.api.model.WebsiteEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteRepository extends JpaRepository<WebsiteEntity, Long> {

    List<WebsiteEntity> findByCategory(WebsiteCategory category, Sort sort);

}
