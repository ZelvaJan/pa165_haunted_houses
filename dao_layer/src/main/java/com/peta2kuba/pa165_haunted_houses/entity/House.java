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
import java.util.Objects;

/**
 * Haunted house entity
 *
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getHauntedSince() {
        return hauntedSince;
    }

    public void setHauntedSince(Timestamp hauntedSince) {
        this.hauntedSince = hauntedSince;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Haunter> getHaunters() {
        return haunters;
    }

    public void setHaunters(List<Haunter> haunters) {
        this.haunters = haunters;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.address);
        hash = 79 * hash + Objects.hashCode(this.hauntedSince);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.haunters);
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
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.haunters, other.haunters)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "House{" + "id=" + id + ", name=" + name + ", address=" + address + ", hauntedSince=" + hauntedSince + ", description=" + description + ", haunters=" + haunters + '}';
    }

}
