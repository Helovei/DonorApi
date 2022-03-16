package com.helovei.donor.api.model.services;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_service_price")
@Data
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private float tariff;

    @Column(name = "cost_of_materials")
    private float costOFMaterials;

    private float price;

    // true - for citizens
    // false - for foreigner
    @Column(name = "for_citizens")
    private boolean forCitizens;

    @ManyToOne
    @JoinColumn(name = "service_category_id")
    private ServiceCategory serviceCategory;

}
