package com.helovei.donorApi.controller;

import com.helovei.donorApi.dto.NewsRequest;
import com.helovei.donorApi.model.NewsCategory;
import com.helovei.donorApi.model.NewsEntity;
import com.helovei.donorApi.security.JwtProvider;
import com.helovei.donorApi.service.NewsCategoryService;
import com.helovei.donorApi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
                newNews.setDateOfPublication(request.getDateOfPublication());
                newsService.save(newNews);
                return HttpStatus.OK;
            }
        return HttpStatus.BAD_REQUEST;
    }
}
