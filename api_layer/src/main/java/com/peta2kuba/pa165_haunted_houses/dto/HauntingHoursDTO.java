package com.peta2kuba.pa165_haunted_houses.dto;

import java.sql.Time;
import java.util.Objects;

/**
 * @author petr.melicherik
 */
public class HauntingHoursDTO {

    private Long id;
    private Time fromTime;
    private Time toTime;

    public HauntingHoursDTO() {
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
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.fromTime);
        hash = 47 * hash + Objects.hashCode(this.toTime);
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
        final HauntingHoursDTO other = (HauntingHoursDTO) obj;
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
        return "HauntingHoursDTO{" + "id=" + id + ", fromTime=" + fromTime + ", toTime=" + toTime + '}';
    }

}
