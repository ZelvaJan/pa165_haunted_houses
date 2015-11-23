package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.HauntingHoursDTO;

import java.util.List;

/**
 * @author turcovsky on 29/10/15.
 */
public interface HauntingHoursDao {

	public void create(HauntingHoursDTO hauntingHours);

	public void edit(HauntingHoursDTO hauntingHours);

	public void remove(HauntingHoursDTO hauntingHours);

	public HauntingHoursDTO findById(Long id);

	public List<HauntingHoursDTO> findAll();
}
