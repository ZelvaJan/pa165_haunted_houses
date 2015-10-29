package com.peta2kuba.pa165_haunted_houses.entity;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author petr.melicherik
 */
@Entity
public class HauntingHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Time from;

    @NotNull
    @Column(nullable = false)
    private Time to;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Time getFrom() {
        return from;
    }

    public void setFrom(final Time from) {
        this.from = from;
    }

    public Time getTo() {
        return to;
    }

    public void setTo(final Time to) {
        this.to = to;
    }
}
