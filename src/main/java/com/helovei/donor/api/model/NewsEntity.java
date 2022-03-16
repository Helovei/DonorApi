package com.helovei.donor.api.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "t_news")
@Data
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "reduce_description", columnDefinition="TEXT")
    private String reduceDescription;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @Column(name = "img_path")
    private String imgPath;

    @Column(name = "date_publication")
    private Date dateOfPublication;

    @Column(name = "time_publication")
    private Time timeOfPublication;

    @ManyToOne
    @JoinColumn(name = "news_category_id")
    private NewsCategory category;

}
