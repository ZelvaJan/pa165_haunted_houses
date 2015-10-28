package com.peta2kuba.pa165_haunted_houses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author turcovsky on 28/10/15.
 */
@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = true)
    private String name;

    @NotNull
    @Column(nullable = true)
    private String address;

    @NotNull
    @Column(nullable = false)
    private Timestamp hauntedSince;


}
