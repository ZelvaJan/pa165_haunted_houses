package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.Ability;

import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
public interface AbilityDao {

	void create(Ability ability);

	void edit(Ability ability);

	void remove(Ability ability);

	Ability findById(Long id);

	List<Ability> findAll();
}
