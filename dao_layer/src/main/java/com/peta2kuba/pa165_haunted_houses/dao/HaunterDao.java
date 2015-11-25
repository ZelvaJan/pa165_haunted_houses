package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.Haunter;

import java.util.List;

/**
 * @author petr.melicherik
 */
public interface HaunterDao {

	void create(Haunter haunter);

	void edit(Haunter haunter);

	void remove(Haunter haunter);

	Haunter findById(Long id);

	Haunter findByName(String name);

	List<Haunter> findAll();

	List<Haunter> findActiveHaunters();
}
