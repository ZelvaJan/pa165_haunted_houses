package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.Haunter;

import java.util.List;

/**
 * @author petr.melicherik
 */
public interface HaunterDao {

	public void create(Haunter haunter);
	public void edit(Haunter haunter);
	public void remove(Haunter haunter);

	public Haunter findById(Long id);
	public Haunter findByName(String name);
	public List<Haunter> findAll();
}
