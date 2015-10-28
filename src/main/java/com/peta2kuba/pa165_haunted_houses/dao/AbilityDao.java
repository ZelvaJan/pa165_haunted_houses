package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;

import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
public interface AbilityDao {

	public void create(Ability ability);

	public void edit(Ability ability);

	public void remove(Long id);

	public Ability findById(Long id);

	public List<Haunter> findAll();
}
