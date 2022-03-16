package com.helovei.donor.api;

import com.helovei.donor.api.properties.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class DonorApiApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DonorApiApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DonorApiApplication.class);
    }


}

