package com.helovei.donorApi.repository;

import com.helovei.donorApi.model.WebSiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<WebSiteEntity, Long> {
}
