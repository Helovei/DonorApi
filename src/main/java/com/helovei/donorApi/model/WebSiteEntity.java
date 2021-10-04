package com.helovei.donorApi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "website")
public class WebSiteEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    private String category;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String url;

    @Setter
    @Getter
    private String img;


}
