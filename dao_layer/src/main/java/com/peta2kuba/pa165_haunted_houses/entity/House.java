package com.peta2kuba.pa165_haunted_houses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String address;

    @NotNull
    @Column(nullable = false)
    private Timestamp hauntedSince;

    private String description;

    @OneToMany
    private List<Haunter> haunters;

	public House(final String name, final String address, final Timestamp hauntedSince, final String description, final List<Haunter> haunters) {

		this.name = name;
		this.address = address;
		this.hauntedSince = hauntedSince;
		this.description = description;
		this.haunters = haunters;
	}

	public House() {

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

	public List<Haunter> getHaunters() {
		return haunters;
	}

	public void setHaunters(final List<Haunter> haunters) {
		this.haunters = haunters;
	}

	@Override
	public String toString() {
		return "House{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", hauntedSince=" + hauntedSince +
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

		final House house = (House) o;

		if (id != null ? !id.equals(house.id) : house.id != null) {
			return false;
		}
		if (name != null ? !name.equals(house.name) : house.name != null) {
			return false;
		}
		if (address != null ? !address.equals(house.address) : house.address != null) {
			return false;
		}
		if (hauntedSince != null ? !hauntedSince.equals(house.hauntedSince) : house.hauntedSince != null) {
			return false;
		}
		if (description != null ? !description.equals(house.description) : house.description != null) {
			return false;
		}
		return !(haunters != null ? !haunters.equals(house.haunters) : house.haunters != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (hauntedSince != null ? hauntedSince.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (haunters != null ? haunters.hashCode() : 0);
		return result;
	}
}
