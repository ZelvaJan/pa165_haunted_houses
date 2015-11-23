package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.AbilityDao;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author petr.melicherik
 */
@Repository
public class AbilityDaoImpl
		implements AbilityDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Ability ability) {
		em.persist(ability);
	}

	@Override
	public void edit(Ability ability) {
		em.merge(ability);
	}

	@Override
	public void remove(Ability ability) {
		em.remove(ability);
	}

	@Override
	public Ability findById(Long id) {
		return em.find(Ability.class, id);
	}

	@Override
	public List<Ability> findAll() {
		return em.createQuery("select ability from Ability ability", Ability.class).getResultList();
	}
}
