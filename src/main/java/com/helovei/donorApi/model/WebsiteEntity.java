package com.helovei.donorApi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_websites")
public class WebsiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private WebsiteCategory category;

    private String url;

    private String imgPath;

}
