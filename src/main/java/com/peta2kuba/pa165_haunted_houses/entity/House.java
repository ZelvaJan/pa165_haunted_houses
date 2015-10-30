package com.peta2kuba.pa165_haunted_houses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author turcovsky on 28/10/15.
 */
@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
    @Column
    private String name;

	@NotNull
    @Column
    private String address;

    public House() {
    }

    public House(Long id, String name, String address, Timestamp hauntedSince) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hauntedSince = hauntedSince;
    }
    
	public Timestamp getHauntedSince() {
		return hauntedSince;
	}

	public void setHauntedSince(final Timestamp hauntedSince) {
		this.hauntedSince = hauntedSince;
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

	@NotNull
    @Column(nullable = false)

    private Timestamp hauntedSince;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.address);
        hash = 47 * hash + Objects.hashCode(this.hauntedSince);
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
        final House other = (House) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.hauntedSince, other.hauntedSince)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "House{" + "id=" + id + ", name=" + name + ", address=" + address + ", hauntedSince=" + hauntedSince + '}';
    }


}
