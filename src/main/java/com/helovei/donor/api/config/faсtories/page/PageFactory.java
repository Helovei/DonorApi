package com.helovei.donor.api.config.faсtories.page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageFactory {
    public static Pageable createPageTemplate(PagesType type) {
        Sort sortById = Sort.by("id");
        switch (type) {
            case DEFAULT_FAST_NEWS_PAGE:
                return PageRequest.of(0, 5, sortById);
            default:
            case DEFAULT_NEWS_PAGE:
                return PageRequest.of(0, 4, sortById);
        }
    }
}
