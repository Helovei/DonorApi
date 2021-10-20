package com.helovei.donorApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsRequest {

    private String title;
    private String description;
    private String imgPath;
    private String dateOfPublication;
    private String category;

}
