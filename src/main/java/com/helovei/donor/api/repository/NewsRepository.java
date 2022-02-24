package com.helovei.donor.api.repository;

import com.helovei.donor.api.model.NewsCategory;
import com.helovei.donor.api.model.NewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

    NewsEntity findNewsEntityById(Long id);

    Page<NewsEntity> findNewsEntityByCategory(Pageable page, NewsCategory category);
}
