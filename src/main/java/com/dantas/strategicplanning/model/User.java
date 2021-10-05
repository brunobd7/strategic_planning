package com.dantas.strategicplanning.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String login;

    // ANNOTATION TO LARGE OBJECT TO GENERATO COLUM TEXT NOT VARCHAR 255
    @Lob
    @NotNull
    @NotEmpty
    private String password;

    // USERS OWNED BY ORG, ORG IS OWNER N USERS
    @ManyToOne
    @JoinColumn(name = "origanization_id")
    private Organization organization;

}
