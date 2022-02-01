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

    @GetMapping("/website/all")
    public List<WebsiteEntity> getWebSites() {
        return webSiteService.getAll();
    }

    @PostMapping("/website/findByCategory/")
    public List<WebsiteEntity> getHospitalWebSite(@RequestBody WebsiteCategory category) {
        WebsiteCategory foundCategory = webSiteCategoryService.findByName(category.getName());
        return webSiteService.findByCategory(foundCategory);
    }

    @GetMapping("/websites/hospitals")
    public List<WebsiteEntity> getWebsitesByOther(){
       WebsiteCategory category = webSiteCategoryService.findByName("OTHER");
       return webSiteService.findByCategory(category);
    }

    @PostMapping("/admin/website/addCategory")
    public HttpStatus addWebSites(@RequestBody WebsiteCategory category) {
        WebsiteCategory foundCategory = webSiteCategoryService.findByName(category.getName());
        if (foundCategory == null) {
            webSiteCategoryService.save(category);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @PostMapping("/admin/website/addWebSite")
    public HttpStatus addWebSites(@RequestBody RequestAddWebSite request) {
        WebsiteCategory foundCategory = webSiteCategoryService.findByName(request.getCategory());
        WebsiteEntity newWebsite = new WebsiteEntity();
        if (request != null && foundCategory != null) {
            newWebsite.setCategory(foundCategory);
            newWebsite.setName(request.getName());
            newWebsite.setImgPath(request.getImgPath());
            newWebsite.setUrl(request.getUrl());
            newWebsite.setCategory(foundCategory);
            webSiteService.save(newWebsite);
            return HttpStatus.OK;
        }
        return HttpStatus.OK;
    }


}
