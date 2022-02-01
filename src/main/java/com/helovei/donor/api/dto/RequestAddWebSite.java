package com.helovei.donor.api.dto;

import lombok.Data;

@Data
public class RequestAddWebSite {

    private String name;

    private String category;

    private String url;

    private String imgPath;

}
