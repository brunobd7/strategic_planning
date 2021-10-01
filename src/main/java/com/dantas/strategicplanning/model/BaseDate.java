package com.dantas.strategicplanning.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "base_dates")
public class BaseDate {

    @Id
    private Long id;

    private LocalDate initialDate;
    private LocalDate finalDate;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
