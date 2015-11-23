package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.HauntingHoursDTO;

import java.util.List;

/**
 * @author turcovsky on 29/10/15.
 */
public interface HauntingHoursFacade {

	void create(HauntingHoursDTO hauntingHours);

	void edit(HauntingHoursDTO hauntingHours);

	void remove(HauntingHoursDTO hauntingHours);

	HauntingHoursDTO findById(Long id);

	List<HauntingHoursDTO> findAll();
}
