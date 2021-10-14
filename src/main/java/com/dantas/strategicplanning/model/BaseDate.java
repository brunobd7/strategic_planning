package com.dantas.strategicplanning.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "base_dates")
public class BaseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate initialDate;
    @NotNull
    private LocalDate finalDate;
    @NotNull
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    @NotNull
    private Organization organization;
}
