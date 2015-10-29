/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.PersonDao;
import com.peta2kuba.pa165_haunted_houses.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author skornok
 */
public class PersonDaoImpl
		implements PersonDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Person user) {
		em.persist(user);
	}

	@Override
	public void edit(Person user) {
		em.merge(user);
	}

	@Override
	public void remove(Person user) {
		em.remove(user);
	}

	@Override
	public Person findById(Long id) {
		return em.find(Person.class, id);
	}

	@Override
	public List<Person> findAll() {
		return em.createQuery("SELECT user FROM User user", Person.class).getResultList();
	}

}
