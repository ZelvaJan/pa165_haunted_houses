package com.peta2kuba.pa165_haunted_houses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	private HauntingHours hauntingHours;

	@NotNull
	@Column(nullable = false)
	private String description;

	@NotNull
	@Column(nullable = false)
	private String hauntingReason;

	public List<Ability> getAbility() {
		return ability;
	}

	public void setAbility(final List<Ability> ability) {
		this.ability = ability;
	}

	@OneToMany
	@Column
	private List<Ability> ability = new ArrayList<Ability>();

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

}
