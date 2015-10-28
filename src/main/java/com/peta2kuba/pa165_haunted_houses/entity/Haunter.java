package com.peta2kuba.pa165_haunted_houses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.sql.Time;

/**
 * @author petr.melicherik
 */
@Entity
public class Haunter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Time hantingFrom;

    @NotNull
    @Column(nullable = false)
    private Time hauntingTo;

    @NotNull
    @Column(nullable = false, unique = true)
    private String description;

    @NotNull
    @Column(nullable = false, unique = true)
    private String hauntingReason;

	@OneToMany
    @Column(nullable = false, unique = true)
    private Ability ability;

}
