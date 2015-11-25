package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.HaunterDao;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author petr.melicherik
 */
@Repository
public class HaunterDaoImpl
		implements HaunterDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Haunter haunter) {
		em.persist(haunter);
	}

	@Override
	public void edit(final Haunter haunter) {
		em.merge(haunter);
	}

	@Override
	public void remove(final Haunter haunter) {
		em.remove(haunter);
	}

	@Override
	public Haunter findById(final Long id) {
		return em.find(Haunter.class, id);
	}

	@Override
	public Haunter findByName(final String name) {
		return null;
	}

	@Override
	public List<Haunter> findAll() {
		return em.createQuery("select haunter from Haunter haunter", Haunter.class).getResultList();
	}

	@Override
	public List<Haunter> findActiveHaunters() {
		return null;		// TODO implement this!!!
	}
}
