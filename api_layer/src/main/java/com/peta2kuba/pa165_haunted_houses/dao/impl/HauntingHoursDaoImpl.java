package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.HauntingHoursDao;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHoursDTO;
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
	public void create(final HauntingHoursDTO hauntingHours) {
		em.persist(hauntingHours);
	}

	@Override
	public void edit(final HauntingHoursDTO hauntingHours) {
		em.merge(hauntingHours);
	}

	@Override
	public void remove(final HauntingHoursDTO hauntingHours) {
		em.remove(hauntingHours);
	}

	@Override
	public HauntingHoursDTO findById(final Long id) {
		return em.find(HauntingHoursDTO.class, id);
	}

	@Override
	public List<HauntingHoursDTO> findAll() {
		return em.createQuery("select hauntingHours from HauntingHours hauntingHours", HauntingHoursDTO.class).getResultList();
	}
}
