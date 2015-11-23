package com.peta2kuba.pa165_haunted_houses.dto;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author skornok
 */
@Entity
public class AbilityDTO {

	private Long id;
	private String name;
	private String description;
	private List<HaunterDTO> haunters = new ArrayList<HaunterDTO>();

	public AbilityDTO() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public List<HaunterDTO> getHaunters() {
		return haunters;
	}

	public void setHaunters(final List<HaunterDTO> haunters) {
		this.haunters = haunters;
	}

	@Override
	public String toString() {
		return "AbilityDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", haunters=" + haunters +
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

		final AbilityDTO abilityDTO = (AbilityDTO) o;

		if (id != null ? !id.equals(abilityDTO.id) : abilityDTO.id != null) {
			return false;
		}
		if (name != null ? !name.equals(abilityDTO.name) : abilityDTO.name != null) {
			return false;
		}
		if (description != null ? !description.equals(abilityDTO.description) : abilityDTO.description != null) {
			return false;
		}
		return !(haunters != null ? !haunters.equals(abilityDTO.haunters) : abilityDTO.haunters != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (haunters != null ? haunters.hashCode() : 0);
		return result;
	}
}
