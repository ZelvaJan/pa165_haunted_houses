package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.House;

import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
public interface HouseDao {

	public void create(House house);

	public void edit(House house);

	public void remove(Long id);

	public House findById(Long id);

	public List<House> findAll();
}
