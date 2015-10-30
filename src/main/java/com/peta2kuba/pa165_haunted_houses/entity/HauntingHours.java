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

	public void setId(final Long id) {
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
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final HauntingHours that = (HauntingHours) o;

		if (!id.equals(that.id)) {
			return false;
		}
		if (!fromTime.equals(that.fromTime)) {
			return false;
		}
		return toTime.equals(that.toTime);

	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.id);
		hash = 67 * hash + Objects.hashCode(this.fromTime);
		hash = 67 * hash + Objects.hashCode(this.toTime);
		return hash;
	}

	@Override
	public String toString() {
		return "HauntingHours{" + "id=" + id + ", fromTime=" + fromTime + ", toTime=" + toTime + '}';
	}
}
