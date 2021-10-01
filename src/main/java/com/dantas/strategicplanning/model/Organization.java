package com.dantas.strategicplanning.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="register_number")
    private String registerNumeber;

    @Column(name = "corporate_name")
    private String corporateName;


}
