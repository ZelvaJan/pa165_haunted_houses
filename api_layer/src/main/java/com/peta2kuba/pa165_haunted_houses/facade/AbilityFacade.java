package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.AbilityDTO;

import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
public interface AbilityFacade {

	public void create(AbilityDTO ability);

	public void edit(AbilityDTO ability);

	public void remove(AbilityDTO ability);

	public AbilityDTO findById(Long id);

	public List<AbilityDTO> findAll();
}
