package com.peta2kuba.pa165_haunted_houses.dto;


import java.util.ArrayList;
import java.util.List;

/**
 * @author skornok
 */
public class HaunterDTO {

	private Long id;
	private String name;
	private HauntingHoursDTO hauntingHours;
	private String description;
	private String hauntingReason;
	private List<AbilityDTO> ability = new ArrayList<AbilityDTO>();

	public HaunterDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public HauntingHoursDTO getHauntingHours() {
		return hauntingHours;
	}

	public void setHauntingHours(final HauntingHoursDTO hauntingHours) {
		this.hauntingHours = hauntingHours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getHauntingReason() {
		return hauntingReason;
	}

	public void setHauntingReason(final String hauntingReason) {
		this.hauntingReason = hauntingReason;
	}

	public List<AbilityDTO> getAbility() {
		return ability;
	}

	public void setAbility(final List<AbilityDTO> ability) {
		this.ability = ability;
	}

	@Override
	public String toString() {
		return "HaunterDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", hauntingHours=" + hauntingHours +
				", description='" + description + '\'' +
				", hauntingReason='" + hauntingReason + '\'' +
				", ability=" + ability +
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

		final HaunterDTO that = (HaunterDTO) o;

		if (id != null ? !id.equals(that.id) : that.id != null) {
			return false;
		}
		if (name != null ? !name.equals(that.name) : that.name != null) {
			return false;
		}
		if (hauntingHours != null ? !hauntingHours.equals(that.hauntingHours) : that.hauntingHours != null) {
			return false;
		}
		if (description != null ? !description.equals(that.description) : that.description != null) {
			return false;
		}
		if (hauntingReason != null ? !hauntingReason.equals(that.hauntingReason) : that.hauntingReason != null) {
			return false;
		}
		return !(ability != null ? !ability.equals(that.ability) : that.ability != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (hauntingHours != null ? hauntingHours.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (hauntingReason != null ? hauntingReason.hashCode() : 0);
		result = 31 * result + (ability != null ? ability.hashCode() : 0);
		return result;
	}
}
