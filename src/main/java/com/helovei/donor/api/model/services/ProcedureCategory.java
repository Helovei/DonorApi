package com.helovei.donor.api.model.services;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_procedure_category")
@Data
public class ProcedureCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


}
