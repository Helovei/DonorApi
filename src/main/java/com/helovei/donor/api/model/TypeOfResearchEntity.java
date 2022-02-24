package com.helovei.donor.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class TypeOfResearchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "type_of_service_id")
    private TypeOfServiceEntity typeOfService;

}
