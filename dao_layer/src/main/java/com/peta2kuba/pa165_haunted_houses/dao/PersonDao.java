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

	void create(Person person);

	void edit(Person person);

	void remove(Person person);

	Person findById(Long id);

	Person findByEmail(String email);

	List<Person> findAll();

}
