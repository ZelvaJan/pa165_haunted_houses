package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;

import java.util.List;

/**
 * @author turcovsky on 29/10/15.
 */
public interface HauntingHoursDao {

	void create(HauntingHours hauntingHours);

	void edit(HauntingHours hauntingHours);

	void remove(HauntingHours hauntingHours);

	HauntingHours findById(Long id);

	List<HauntingHours> findAll();
}
