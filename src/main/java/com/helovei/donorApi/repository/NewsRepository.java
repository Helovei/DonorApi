package com.helovei.donorApi.repository;

import com.helovei.donorApi.model.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

    @Query(value = "SELECT * FROM t_news ORDER BY date_publication DESC LIMIT 5 ",
            nativeQuery = true)
    List<NewsEntity> getLastEntity();

}
