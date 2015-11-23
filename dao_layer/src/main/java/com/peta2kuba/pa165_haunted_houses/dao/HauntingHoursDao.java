package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;

import java.util.List;

/**
 * @author turcovsky on 29/10/15.
 */
public interface HauntingHoursDao {

	public void create(HauntingHours hauntingHours);

	public void edit(HauntingHours hauntingHours);

	public void remove(HauntingHours hauntingHours);

	public HauntingHours findById(Long id);

	public List<HauntingHours> findAll();
}
