package com.helovei.donorApi.repository;

import com.helovei.donorApi.model.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsCategoryRepository extends JpaRepository<NewsCategory, Long> {
    NewsCategory findByName(String name);
}
