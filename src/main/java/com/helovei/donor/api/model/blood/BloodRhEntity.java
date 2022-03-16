package com.helovei.donor.api.model.blood;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_blood_rh")
public class BloodRhEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
