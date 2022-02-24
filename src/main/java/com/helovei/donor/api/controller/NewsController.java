package com.helovei.donor.api.controller;

import com.helovei.donor.api.dto.NewsRequest;
import com.helovei.donor.api.dto.ReduceNewsResponse;
import com.helovei.donor.api.model.NewsCategory;
import com.helovei.donor.api.model.NewsEntity;
import com.helovei.donor.api.service.NewsCategoryService;
import com.helovei.donor.api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

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
    public Page<NewsEntity> getPage(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "5") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String SortBy) {
        return newsService.getPage(pageNo, pageSize, SortBy);
    }

    @GetMapping("/news/filter")
    public Page<NewsEntity> getPage(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "5") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String SortBy,
                                    @RequestParam Long categoryId) {
        NewsCategory categoryEntity = newsCategoryService.findById(categoryId);
        if (categoryEntity != null) {
            return newsService.getPageByCategory(pageNo, SortBy, pageSize, categoryEntity);
        }
        return null;
    }

    @GetMapping(value = "/news/find", params = "id")
    public NewsEntity getNewsById(@RequestParam Long id) {
        return newsService.getNewsEntityById(id);
    }

    @GetMapping("/news/categories")
    public List<NewsCategory> getNewsCategories() {
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
            if (request.getReduceDescription().length() == 0) {
                String description = request.getDescription();
                if (description.length() > 512) {
                    description = description.substring(0, 512);
                    description = description + "...";
                }
                newNews.setReduceDescription(description);
            }
            newNews.setDescription(request.getDescription());
            newNews.setImgPath(request.getImgPath());
            newNews.setDateOfPublication(new Date(System.currentTimeMillis()));
            newNews.setTimeOfPublication(new Time(System.currentTimeMillis()));
            newsService.save(newNews);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    //dev
//    @GetMapping("news/fix")
//    public HttpStatus fixNews() {
//        List<NewsEntity> newsList = newsService.getAll();
//        newsList.stream().map(newsEntity -> {
//            String description = newsEntity.getDescription();
//            if (description.length() <= 512) {
//                newsEntity.setReduceDescription(description);
//            } else {
//                description = description.substring(0, 512);
//                description = description + "...";
//                newsEntity.setReduceDescription(description);
//            }
//            return newsEntity;
//        }).collect(Collectors.toList());
//        newsList.forEach(newsService::save);
//        return HttpStatus.OK;
//    }
}
