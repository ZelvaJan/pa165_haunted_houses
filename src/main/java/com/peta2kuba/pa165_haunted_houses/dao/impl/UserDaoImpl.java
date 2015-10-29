/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.UserDao;
import com.peta2kuba.pa165_haunted_houses.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author skornok
 */
public class UserDaoImpl
		implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(User user) {
		em.persist(user);
	}

	@Override
	public void edit(User user) {
		em.merge(user);
	}

	@Override
	public void remove(User user) {
		em.remove(user);
	}

	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> findAll() {
		return em.createQuery("SELECT user FROM User user", User.class).getResultList();
	}

}
