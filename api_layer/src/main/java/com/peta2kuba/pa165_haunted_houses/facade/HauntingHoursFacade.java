package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.HauntingHoursDTO;

import java.util.List;

/**
 * @author turcovsky on 29/10/15.
 */
public interface HauntingHoursFacade {

	public void create(HauntingHoursDTO hauntingHours);

	public void edit(HauntingHoursDTO hauntingHours);

	public void remove(HauntingHoursDTO hauntingHours);

	public HauntingHoursDTO findById(Long id);

	public List<HauntingHoursDTO> findAll();
}
