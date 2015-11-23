package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;

import java.util.List;

/**
 * @author petr.melicherik
 */
public interface HaunterFacade {

	void create(HaunterDTO haunter);

	void edit(HaunterDTO haunter);

	void remove(HaunterDTO haunter);

	HaunterDTO findById(Long id);

	HaunterDTO findByName(String name);

	List<HaunterDTO> findAll();

	List<HaunterDTO> findActiveHaunters();
}
