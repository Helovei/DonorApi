package com.helovei.donor.api.model.services;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_service_category")
@Data
public class ServiceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "procedure_category_id")
    private ProcedureCategory procedureCategories;

}
