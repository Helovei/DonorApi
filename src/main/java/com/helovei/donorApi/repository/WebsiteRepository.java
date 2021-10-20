package com.helovei.donorApi.repository;

import com.helovei.donorApi.model.WebsiteCategory;
import com.helovei.donorApi.model.WebsiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteRepository extends JpaRepository<WebsiteEntity, Long> {

    List<WebsiteEntity> findByCategory(WebsiteCategory category);

}
