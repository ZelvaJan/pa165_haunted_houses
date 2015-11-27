package com.peta2kuba.pa165_haunted_houses.dto;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author turcovsky
 */
public class HouseDTO {

    private Long id;
    private String name;
    private String address;
    private Timestamp hauntedSince;
    private String description;
    private List<HaunterDTO> haunters;

    public HouseDTO() {
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

    public List<HaunterDTO> getHaunters() {
        return haunters;
    }

    public void setHaunters(List<HaunterDTO> haunters) {
        this.haunters = haunters;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.address);
        hash = 29 * hash + Objects.hashCode(this.hauntedSince);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.haunters);
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
        final HouseDTO other = (HouseDTO) obj;
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
        return "HouseDTO{" + "id=" + id + ", name=" + name + ", address=" + address + ", hauntedSince=" + hauntedSince + ", description=" + description + ", haunters=" + haunters + '}';
    }

}
