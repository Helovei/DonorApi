package com.helovei.donorApi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_news")
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    @Column(name = "title")
    private String title;

    @Setter
    @Getter
    @Column(name = "description")
    private String description;

    @Getter
    @Setter
    @Column(name = "img_path")
    private String imgPath;

    @Getter
    @Setter
    @Column(name = "date_publication")
    private String dateOfPublication;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "news_category_id")
    private NewsCategory category;

}
