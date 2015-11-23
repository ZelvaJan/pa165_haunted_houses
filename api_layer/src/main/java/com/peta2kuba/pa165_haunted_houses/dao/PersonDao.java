/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.PersonDTO;

import java.util.List;

/**
 * @author skornok
 */
public interface PersonDao {

	public void create(PersonDTO person);

	public void edit(PersonDTO person);

	public void remove(PersonDTO person);

	public PersonDTO findById(Long id);

	public List<PersonDTO> findAll();

}
