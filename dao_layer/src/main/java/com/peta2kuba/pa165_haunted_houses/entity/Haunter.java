package com.peta2kuba.pa165_haunted_houses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 * Haunter entity with its Abilities and additional information
 *
 * @author petr.melicherik
 */
@Entity
public class Haunter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(nullable = false)
    private HauntingHours hauntingHours;

    private String description;

    private String hauntingReason;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "Haunter_ability",
            joinColumns = @JoinColumn(name = "Haunter_id"),
            inverseJoinColumns = @JoinColumn(name = "Ability_id")
    )
    private List<Ability> abilities;

    public Haunter() {

    }

    public Haunter(Long id, String name, HauntingHours hauntingHours) {
        this.id = id;
        this.name = name;
        this.hauntingHours = hauntingHours;
    }

    public Haunter(Long id, String name, HauntingHours hauntingHours, String description, String hauntingReason) {
        this.id = id;
        this.name = name;
        this.hauntingHours = hauntingHours;
        this.description = description;
        this.hauntingReason = hauntingReason;
    }

    public Haunter(final String name, final HauntingHours hauntingHours, final String description, final String hauntingReason, final List<Ability> abilities) {
        this.name = name;
        this.hauntingHours = hauntingHours;
        this.description = description;
        this.hauntingReason = hauntingReason;
        this.abilities = abilities;
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

    public HauntingHours getHauntingHours() {
        return hauntingHours;
    }

    public void setHauntingHours(HauntingHours hauntingHours) {
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

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.hauntingHours);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.hauntingReason);
        hash = 59 * hash + Objects.hashCode(this.abilities);
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
        final Haunter other = (Haunter) obj;
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
        return "Haunter{" + "id=" + id + ", name=" + name + ", hauntingHours=" + hauntingHours + ", description=" + description + ", hauntingReason=" + hauntingReason + ", abilities=" + abilities + '}';
    }

}
