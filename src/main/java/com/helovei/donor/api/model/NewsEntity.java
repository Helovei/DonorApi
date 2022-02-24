package com.helovei.donor.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "t_news")
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Setter
    @Getter
    @Column(name = "title")
    private String title;

    @Setter
    @Getter
    @Column(name = "reduce_description", columnDefinition="TEXT")
    private String reduceDescription;

    @Setter
    @Getter
    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @Getter
    @Setter
    @Column(name = "img_path")
    private String imgPath;

    @Getter
    @Setter
    @Column(name = "date_publication")
    private Date dateOfPublication;

    @Getter
    @Setter
    @Column(name = "time_publication")
    private Time timeOfPublication;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "news_category_id")
    private NewsCategory category;

}
