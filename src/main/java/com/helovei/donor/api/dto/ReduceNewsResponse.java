package com.helovei.donor.api.dto;

import com.helovei.donor.api.model.NewsCategory;
import com.helovei.donor.api.model.NewsEntity;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class ReduceNewsResponse {

    public ReduceNewsResponse(NewsEntity news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.reduceDescription = news.getReduceDescription();
        this.category = news.getCategory();
        this.timeOfPublication = news.getTimeOfPublication();
        this.dateOfPublication = news.getDateOfPublication();
    }

    private Long id;
    private String title;
    private String reduceDescription;
    private Time timeOfPublication;
    private Date dateOfPublication;
    private NewsCategory category;

}
