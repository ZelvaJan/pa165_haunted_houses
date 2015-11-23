package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.HouseDTO;

import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
public interface HouseFacade {

	void create(HouseDTO house);

	void edit(HouseDTO house);

	void remove(HouseDTO house);

	HouseDTO findById(Long id);

	List<HouseDTO> findAll();
}
