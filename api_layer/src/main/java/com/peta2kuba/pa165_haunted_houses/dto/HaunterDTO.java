package com.peta2kuba.pa165_haunted_houses.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author skornok
 */
public class HaunterDTO {

    private Long id;
    private String name;
    private HauntingHoursDTO hauntingHours;
    private String description;
    private String hauntingReason;
    private List<AbilityDTO> abilities = new ArrayList<AbilityDTO>();

    public HaunterDTO() {
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

    public HauntingHoursDTO getHauntingHours() {
        return hauntingHours;
    }

    public void setHauntingHours(HauntingHoursDTO hauntingHours) {
        this.hauntingHours = hauntingHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHauntingReason() {
        return hauntingReason;
    }

    public void setHauntingReason(String hauntingReason) {
        this.hauntingReason = hauntingReason;
    }

    public List<AbilityDTO> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityDTO> abilities) {
        this.abilities = abilities;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.hauntingHours);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.hauntingReason);
        hash = 83 * hash + Objects.hashCode(this.abilities);
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
        final HaunterDTO other = (HaunterDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.hauntingHours, other.hauntingHours)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.hauntingReason, other.hauntingReason)) {
            return false;
        }
        if (!Objects.equals(this.abilities, other.abilities)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HaunterDTO{" + "id=" + id + ", name=" + name + ", hauntingHours=" + hauntingHours + ", description=" + description + ", hauntingReason=" + hauntingReason + ", abilities=" + abilities + '}';
    }

}
