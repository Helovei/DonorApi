package com.helovei.donorApi.repository;

import com.helovei.donorApi.model.WebsiteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSiteCategoryRepository extends JpaRepository<WebsiteCategory, Long> {

    WebsiteCategory findByName(String name);
}
