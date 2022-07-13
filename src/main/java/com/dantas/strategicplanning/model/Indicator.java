package com.dantas.strategicplanning.model;

import com.dantas.strategicplanning.enums.UnitMeasurement;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "indicators")
public class Indicator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private UnitMeasurement unitMeasurement;

    @NotNull
    @Size(min = 5, max = 100)
    private String name;

}
