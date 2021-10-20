package com.helovei.donorApi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "t_news_category")
public class NewsCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    @Column(name = "name")
    private String name;
}
