package com.peta2kuba.pa165_haunted_houses.dto;

import javax.persistence.Entity;
import java.sql.Time;

/**
 * @author petr.melicherik
 */
@Entity
public class HauntingHoursDTO {

	private Long id;
	private Time fromTime;
	private Time toTime;

	public HauntingHoursDTO() {
	}

	public Long getId() {

		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Time getFromTime() {
		return fromTime;
	}

	public void setFromTime(final Time fromTime) {
		this.fromTime = fromTime;
	}

	public Time getToTime() {
		return toTime;
	}

	public void setToTime(final Time toTime) {
		this.toTime = toTime;
	}

	@Override
	public String toString() {
		return "HauntingHoursDTO{" +
				"id=" + id +
				", fromTime=" + fromTime +
				", toTime=" + toTime +
				'}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final HauntingHoursDTO hours = (HauntingHoursDTO) o;

		if (id != null ? !id.equals(hours.id) : hours.id != null) {
			return false;
		}
		if (fromTime != null ? !fromTime.equals(hours.fromTime) : hours.fromTime != null) {
			return false;
		}
		return !(toTime != null ? !toTime.equals(hours.toTime) : hours.toTime != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (fromTime != null ? fromTime.hashCode() : 0);
		result = 31 * result + (toTime != null ? toTime.hashCode() : 0);
		return result;
	}
}
