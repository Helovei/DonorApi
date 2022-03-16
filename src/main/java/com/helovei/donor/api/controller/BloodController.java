package com.helovei.donor.api.controller;

import com.helovei.donor.api.model.blood.BloodRhEntity;
import com.helovei.donor.api.model.blood.BloodStatusEntity;
import com.helovei.donor.api.service.blood.BloodRhService;
import com.helovei.donor.api.service.blood.BloodStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BloodController {

    private final BloodStatusService bloodStatusService;
    private final BloodRhService bloodRhService;

    @Autowired
    public BloodController(BloodStatusService bloodStatusService, BloodRhService bloodRhService) {
        this.bloodStatusService = bloodStatusService;
        this.bloodRhService = bloodRhService;
    }

    @GetMapping("/bloodStatus")
    public List<BloodStatusEntity> getBloodStatus(){
        return bloodStatusService.findAllBloodStatusByBloodRh(bloodRhService.getAll());
    }

    @GetMapping("/bloodStatus/Rh")
    public List<BloodRhEntity> getBloodRh() {
        return bloodRhService.getAll();
    }
}
