package com.helovei.donor.api.controller;

import com.helovei.donor.api.model.services.ProcedureCategory;
import com.helovei.donor.api.model.services.ServiceCategory;
import com.helovei.donor.api.model.services.ServiceEntity;
import com.helovei.donor.api.service.ProcedureCategoryService;
import com.helovei.donor.api.service.ServiceCategoryService;
import com.helovei.donor.api.service.ServicePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceServiceController {

    private final ProcedureCategoryService procedureCategoryService;
    private final ServiceCategoryService serviceCategoryService;
    private final ServicePriceService servicePriceService;

    @Autowired
    public PriceServiceController(ProcedureCategoryService procedureCategoryService, ServiceCategoryService serviceCategoryService, ServicePriceService servicePriceService) {
        this.procedureCategoryService = procedureCategoryService;
        this.serviceCategoryService = serviceCategoryService;
        this.servicePriceService = servicePriceService;
    }

    @GetMapping("/services/all")
    public List<ServiceEntity> getPrices(){
        return servicePriceService.getAll();
    }

    @GetMapping("/services")
    public List<ServiceEntity> getPricesByForCitizens(@RequestParam(defaultValue = "true") Boolean forCitizens){
        return servicePriceService.findByForCitizens(forCitizens);
    }

    @GetMapping("/services/procedure_category")
    public List<ProcedureCategory> getProcedureCategory(){
        return procedureCategoryService.getAll();
    }

    @GetMapping("/services/service_category")
    public List<ServiceCategory> getServiceCategory(){
        return serviceCategoryService.getAll();
    }


}
