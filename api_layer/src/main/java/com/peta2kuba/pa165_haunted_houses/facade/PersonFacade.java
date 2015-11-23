package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;

import java.util.List;

/**
 * @author skornok
 */
public interface PersonFacade {

	public void create(PersonDTO person);

	public void edit(PersonDTO person);

	public void remove(PersonDTO person);

	public PersonDTO findById(Long id);

	public List<PersonDTO> findAll();

}
