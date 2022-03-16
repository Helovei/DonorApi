package com.helovei.donor.api.model.blood;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_blood_satus")
public class BloodStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blood_rh_id")
    private BloodRhEntity rH;

    private Integer value;
}
