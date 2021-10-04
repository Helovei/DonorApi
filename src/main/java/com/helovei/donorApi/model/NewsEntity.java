package com.helovei.donorApi.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class NewsEntity {

    public NewsEntity() {
        this.counter = 0;
    }

    public NewsEntity(CategoryEntity categoryEntity, String title, String description, String image) {
        this.categoryEntity = categoryEntity;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @NotNull
    @OneToOne
    private CategoryEntity categoryEntity;

    @NotNull
    @Getter
    @Setter
    private String title;

    @NotNull
    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String image;

    @NotNull
    @Getter
    @Setter
    private int counter;

    public Long getId() {
        return id;
    }
}
