package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.AbilityDTO;

import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
public interface AbilityFacade {

	void create(AbilityDTO ability);

	void edit(AbilityDTO ability);

	void remove(AbilityDTO ability);

	AbilityDTO findById(Long id);

	List<AbilityDTO> findAll();
}
