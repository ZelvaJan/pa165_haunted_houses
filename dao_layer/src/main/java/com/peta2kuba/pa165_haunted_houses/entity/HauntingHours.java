package com.peta2kuba.pa165_haunted_houses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Objects;

/**
 * Entity of hours between which is a Haunter haunting every day
 *
 * @author petr.melicherik
 */
@Entity
public class HauntingHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Time fromTime;

    @NotNull
    @Column(nullable = false)
    private Time toTime;

    public HauntingHours() {
    }

    public HauntingHours(Long id, Time fromTime, Time toTime) {
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getFromTime() {
        return fromTime;
    }

    public void setFromTime(Time fromTime) {
        this.fromTime = fromTime;
    }

    public Time getToTime() {
        return toTime;
    }

    public void setToTime(Time toTime) {
        this.toTime = toTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.fromTime);
        hash = 83 * hash + Objects.hashCode(this.toTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HauntingHours other = (HauntingHours) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fromTime, other.fromTime)) {
            return false;
        }
        if (!Objects.equals(this.toTime, other.toTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HauntingHours{" + "id=" + id + ", fromTime=" + fromTime + ", toTime=" + toTime + '}';
    }

}
