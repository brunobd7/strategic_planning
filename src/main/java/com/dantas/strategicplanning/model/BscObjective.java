package com.dantas.strategicplanning.model;

import com.dantas.strategicplanning.enums.Level;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "objectives_indicators",
            joinColumns = @JoinColumn(name = "bsc_objective_id"),
            inverseJoinColumns = @JoinColumn(name = "indicator_id")
    )
    Set<Indicator> indicatorsObjective;

}
