package com.helovei.donor.api.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_website_category")
@Data
public class WebsiteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
