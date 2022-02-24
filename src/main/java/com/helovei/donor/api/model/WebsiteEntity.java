package com.helovei.donor.api.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_websites")
public class WebsiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private WebsiteCategory category;

    @Getter
    @Setter
    private String url;

    @Getter
    @Setter
    private String imgPath;

}
