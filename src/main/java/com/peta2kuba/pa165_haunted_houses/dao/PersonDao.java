/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.entity.Person;

import java.util.List;

/**
 * @author skornok
 */
public interface PersonDao {

	public void create(Person user);

	public void edit(Person user);

	public void remove(Person user);

	public Person findById(Long id);

	public List<Person> findAll();

}
