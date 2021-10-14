package com.dantas.strategicplanning.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bsc_objective")
public class BscObjective extends Objective{

    private Integer weight;

}
