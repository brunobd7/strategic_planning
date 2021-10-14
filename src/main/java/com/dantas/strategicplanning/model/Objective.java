package com.dantas.strategicplanning.model;

import com.dantas.strategicplanning.enums.UnitMeasurement;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    private LocalDate deadLine;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @NotNull
    private Department department;

    @Enumerated(EnumType.ORDINAL)
    private UnitMeasurement unitMeasurement;

}
