package com.peta2kuba.pa165_haunted_houses.dto;

import java.util.ArrayList;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author petr.melicherikŁ
 */
public class AbilityDTO {

    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;
    private String description;
    private ArrayList<HaunterDTO> haunters;

    public AbilityDTO() {

    }

    public AbilityDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<HaunterDTO> getHaunters() {
        return haunters;
    }

    public void setHaunters(ArrayList<HaunterDTO> haunters) {
        this.haunters = haunters;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + Objects.hashCode(this.haunters);
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
        final AbilityDTO other = (AbilityDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
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
        return "AbilityDTO{" + "id=" + id + ", name=" + name + ", description=" + description + ", haunters=" + haunters + '}';
    }

}
