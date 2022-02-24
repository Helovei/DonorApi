package com.helovei.donor.api.controller;

import com.helovei.donor.api.dto.RequestAddWebSite;
import com.helovei.donor.api.model.WebsiteCategory;
import com.helovei.donor.api.model.WebsiteEntity;
import com.helovei.donor.api.service.WebSiteCategoryService;
import com.helovei.donor.api.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebsiteController {

    private final WebSiteService webSiteService;

    private final WebSiteCategoryService webSiteCategoryService;

    @Autowired
    public WebsiteController(WebSiteService webSiteService, WebSiteCategoryService webSiteCategoryService) {
        this.webSiteService = webSiteService;
        this.webSiteCategoryService = webSiteCategoryService;
    }

    @GetMapping("/websites")
    public List<WebsiteEntity> getHospitalWebSite(@RequestParam Long categoryId) {
        WebsiteCategory foundCategory = webSiteCategoryService.findById(categoryId);
        if (foundCategory != null){
            return webSiteService.findByCategory(foundCategory);
        } else {
            return webSiteService.getAll();
        }
    }

    @GetMapping("/websites/categories")
    public List<WebsiteCategory> getWebSiteCategories(){
        return webSiteCategoryService.getAll();
    }
}
