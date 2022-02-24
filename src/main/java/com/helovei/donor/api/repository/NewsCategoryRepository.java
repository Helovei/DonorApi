package com.helovei.donor.api.repository;

import com.helovei.donor.api.model.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsCategoryRepository extends JpaRepository<NewsCategory, Long> {
    NewsCategory findByName(String name);
    NewsCategory findNewsCategoryById(Long id);
}
