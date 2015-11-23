package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;

import java.util.List;

/**
 * @author petr.melicherik
 */
public interface HaunterFacade {

	public void create(HaunterDTO haunter);

	public void edit(HaunterDTO haunter);

	public void remove(HaunterDTO haunter);

	public HaunterDTO findById(Long id);

	public HaunterDTO findByName(String name);

	public List<HaunterDTO> findAll();
}
