package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.HauntingHoursDao;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author turcovsky on 29/10/15.
 */
@Repository
public class HauntingHoursDaoImpl
		implements HauntingHoursDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(final HauntingHours hauntingHours) {
		em.persist(hauntingHours);
	}

	@Override
	public void edit(final HauntingHours hauntingHours) {
		em.merge(hauntingHours);
	}

	@Override
	public void remove(final HauntingHours hauntingHours) {
		em.remove(hauntingHours);
	}

	@Override
	public HauntingHours findById(final Long id) {
		return em.find(HauntingHours.class, id);
	}

	@Override
	public List<HauntingHours> findAll() {
		return em.createQuery("select hauntingHours from HauntingHours hauntingHours", HauntingHours.class).getResultList();
	}
}
