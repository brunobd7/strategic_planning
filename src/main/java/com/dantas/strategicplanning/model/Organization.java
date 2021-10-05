package com.dantas.strategicplanning.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table (name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="register_number")
    @NotNull
    private String registerNumeber;

    @Column(name = "corporate_name")
    @NotNull
    @NotEmpty
    private String corporateName;


}
