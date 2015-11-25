package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.House;

import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
public interface HouseDao {

	void create(House house);

	void edit(House house);

	void remove(House house);

	House findById(Long id);

	List<House> findAll();

	List<Haunter> findHaunters();
}
