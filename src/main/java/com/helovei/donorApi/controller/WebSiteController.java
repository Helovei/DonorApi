package com.helovei.donorApi.controller;

import com.helovei.donorApi.model.WebSiteEntity;
import com.helovei.donorApi.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSiteController {

    @Autowired
    private WebSiteService service;

    @GetMapping("/websites/hospitals")
    public Iterable<WebSiteEntity> getHospitalsWebSite(){
       return service.getAll();
    }

    @PostMapping("/admin/websites/")
    public void addWebSites(){

    }

}
