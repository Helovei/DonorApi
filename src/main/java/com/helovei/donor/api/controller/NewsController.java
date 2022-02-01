package com.helovei.donor.api.controller;

import com.helovei.donor.api.dto.NewsRequest;
import com.helovei.donor.api.model.NewsCategory;
import com.helovei.donor.api.model.NewsEntity;
import com.helovei.donor.api.service.NewsCategoryService;
import com.helovei.donor.api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@RestController
public class NewsController {

    private final NewsService newsService;
    private final NewsCategoryService newsCategoryService;

    @Autowired
    public NewsController(NewsService newsService, NewsCategoryService newsCategoryService) {
        this.newsService = newsService;
        this.newsCategoryService = newsCategoryService;
    }

    @GetMapping("/news")
    public List<NewsEntity> allNews() {
        return newsService.getAll();
    }

    @GetMapping("/news/find")
    public NewsEntity getNewsById(@RequestParam Long id){
        return newsService.getNewsEntityById(id);
    }

    @GetMapping("/news/getLatestNews")
    public List<NewsEntity> getLatestNews(){
        return newsService.getLastEntity();
    }

    @GetMapping("/news/categories")
    public List<NewsCategory> getNewsCategories(){
        return newsCategoryService.getAll();
    }

    @RequestMapping("/admin")

    @PostMapping("/news/addCategory")
    public HttpStatus addNewsCategory(@RequestBody NewsCategory category) {
            NewsCategory foundCategory = newsCategoryService.findByName(category.getName());
            if (category.getName() != null && foundCategory == null) {
                newsCategoryService.save(category);
                return HttpStatus.OK;
            }
        return HttpStatus.BAD_REQUEST;
    }

    @PostMapping("/news/addNews")
    public HttpStatus addNews(@RequestBody NewsRequest request) {
            NewsCategory foundCategory = newsCategoryService.findByName(request.getCategory());
            NewsEntity newNews = new NewsEntity();
            if (foundCategory != null) {
                newNews.setCategory(foundCategory);
                newNews.setTitle(request.getTitle());
                newNews.setDescription(request.getDescription());
                newNews.setImgPath(request.getImgPath());
                newNews.setDateOfPublication(new Date(System.currentTimeMillis()));
                newNews.setTimeOfPublication(new Time(System.currentTimeMillis()));
                newsService.save(newNews);
                return HttpStatus.OK;
            }
        return HttpStatus.BAD_REQUEST;
    }
}
