package com.dantas.strategicplanning.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "okr_objectives")
public class OkrObjective extends Objective{

    @Column(name = "okr_method")
    private Boolean isOkrMethod;

}
