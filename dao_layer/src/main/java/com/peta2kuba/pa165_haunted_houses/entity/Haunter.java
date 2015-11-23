package com.peta2kuba.pa165_haunted_houses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.ManyToOne;

/**
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
	@JoinColumn(nullable=false)
	private HauntingHours hauntingHours;

	private String description;

	private String hauntingReason;

	@ManyToMany
	private List<Ability> ability = new ArrayList<Ability>();

	public List<Ability> getAbility() {
		return ability;
	}

	public void setAbility(final List<Ability> ability) {
		this.ability = ability;
	}

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

	public HauntingHours getHauntingHours() {
		return hauntingHours;
	}

	public void setHauntingHours(final HauntingHours hauntingHours) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.hauntingHours);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.hauntingReason);
        hash = 59 * hash + Objects.hashCode(this.ability);
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
        if (!Objects.equals(this.ability, other.ability)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Haunter{" + "id=" + id + ", name=" + name + ", hauntingHours=" + hauntingHours + ", description=" + description + ", hauntingReason=" + hauntingReason + ", ability=" + ability + '}';
    }

        
}
