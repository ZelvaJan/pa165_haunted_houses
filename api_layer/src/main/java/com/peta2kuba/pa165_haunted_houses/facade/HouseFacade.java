package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.HouseDTO;

import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
public interface HouseFacade {

	public void create(HouseDTO house);

	public void edit(HouseDTO house);

	public void remove(HouseDTO house);

	public HouseDTO findById(Long id);

	public List<HouseDTO> findAll();
}
