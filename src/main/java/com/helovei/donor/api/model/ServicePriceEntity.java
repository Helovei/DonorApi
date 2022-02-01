package com.helovei.donor.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


//to do
//@Entity
public class ServicePriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private float tariff;

    @Getter
    @Setter
    @Column(name = "cost_of_materials")
    private float costOFMaterials;

    @Getter
    @Setter
    private float price;


}
