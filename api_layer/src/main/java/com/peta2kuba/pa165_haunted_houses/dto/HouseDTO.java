package com.peta2kuba.pa165_haunted_houses.dto;

import java.sql.Timestamp;

/**
 * @author turcovsky
 */
public class HouseDTO {

	private Long id;
	private String name;
	private String address;
	private Timestamp hauntedSince;
	private String description;

	public HouseDTO() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public Timestamp getHauntedSince() {
		return hauntedSince;
	}

	public void setHauntedSince(final Timestamp hauntedSince) {
		this.hauntedSince = hauntedSince;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "HouseDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", hauntedSince=" + hauntedSince +
				", description='" + description + '\'' +
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

		final HouseDTO houseDTO = (HouseDTO) o;

		if (id != null ? !id.equals(houseDTO.id) : houseDTO.id != null) {
			return false;
		}
		if (name != null ? !name.equals(houseDTO.name) : houseDTO.name != null) {
			return false;
		}
		if (address != null ? !address.equals(houseDTO.address) : houseDTO.address != null) {
			return false;
		}
		if (hauntedSince != null ? !hauntedSince.equals(houseDTO.hauntedSince) : houseDTO.hauntedSince != null) {
			return false;
		}
		return !(description != null ? !description.equals(houseDTO.description) : houseDTO.description != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (hauntedSince != null ? hauntedSince.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		return result;
	}
}
