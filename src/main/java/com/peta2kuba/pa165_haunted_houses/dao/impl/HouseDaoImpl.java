package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.HouseDao;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
@Repository
public class HouseDaoImpl
		implements HouseDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(final House house) {
		em.persist(house);
	}

	@Override
	public void edit(final House house) {

	}

	@Override
	public void remove(final Long id) {

	}

	@Override
	public House findById(final Long id) {
		return null;
	}

	@Override
	public List<House> findAll() {
		return null;
	}
}
