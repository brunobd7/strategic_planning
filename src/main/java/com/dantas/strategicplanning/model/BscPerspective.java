package com.dantas.strategicplanning.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "bsc_perspective")
public class BscPerspective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    @Size(min = 1 , max = 100)
    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "base_date_id")
    @NotNull
    private BaseDate baseDate;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    @NotNull
    private Organization organization;

}
