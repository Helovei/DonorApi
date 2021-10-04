package com.helovei.donorApi.controller;

import com.helovei.donorApi.model.NewsEntity;
import com.helovei.donorApi.service.CategoryService;
import com.helovei.donorApi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/news")
    private Iterable<NewsEntity> getNews(){
        System.out.println(newsService.getAll());
        return newsService.getAll();
    }

    @PostMapping("/admin/news/addNews")
    private boolean addNews(@RequestBody @Validated NewsEntity news){
        return newsService.save(news);
    }

    @PostMapping("/admin/news/addCategory")
    private boolean addCategory(){
        return false;
    }






}
