package com.dantas.strategicplanning.model;

import com.dantas.strategicplanning.enums.UnitMeasurement;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

//HIBERNATE STRATEGY TO INHERITANCE WITH ONLY CLASSES 'CHILDREN' IN ENTITY MODEL
@Data
@MappedSuperclass
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal goal;

    @NotNull
    @Size(min = 5, max = 100)
    private String description;

    private LocalDate deadLine;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @NotNull
    private Department department;

    @Enumerated(EnumType.STRING)
    private UnitMeasurement unitMeasurement;

    @ManyToOne
    @JoinColumn(name = "base_date_id")
    @NotNull
    private BaseDate baseDate;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    @NotNull
    private Organization organization;

}
