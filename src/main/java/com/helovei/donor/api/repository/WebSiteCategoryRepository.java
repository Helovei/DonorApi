package com.helovei.donor.api.repository;

import com.helovei.donor.api.model.WebsiteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSiteCategoryRepository extends JpaRepository<WebsiteCategory, Long> {

    WebsiteCategory findWebsiteCategoriesById(Long id);

}
