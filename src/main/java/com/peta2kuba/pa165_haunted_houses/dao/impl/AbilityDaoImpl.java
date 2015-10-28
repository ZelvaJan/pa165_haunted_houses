package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.AbilityDao;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
@Repository
public class AbilityDaoImpl
		implements AbilityDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(final Ability ability) {
		em.persist(ability);
	}

	@Override
	public void edit(final Ability ability) {

	}

	@Override
	public void remove(final Long id) {

	}

	@Override
	public Ability findById(final Long id) {
		return null;
	}

	@Override
	public List<Haunter> findAll() {
		return null;
	}
}
