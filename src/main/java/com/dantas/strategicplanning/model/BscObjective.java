package com.dantas.strategicplanning.model;

import com.dantas.strategicplanning.enums.Level;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "bsc_objective")
public class BscObjective extends Objective{

    @NotNull
    @Size(min = 1 , max = 100)
    private Integer weight;

    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToOne
    @JoinColumn(name = "bsc_perspective_id")
    @NotNull
    private BscPerspective bscPerspective;

}
