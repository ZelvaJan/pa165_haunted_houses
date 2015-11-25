package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.dao.HaunterDao;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link com.peta2kuba.pa165_haunted_houses.service_layer.service.HaunterService}. This class is part of the
 * service module of the application that provides the implementation of the
 * business logic.
 *
 * @author skornok on 25/11/15.
 */
@Service
public class HaunterServiceImpl implements HaunterService {

	@Autowired
	private HaunterDao haunterDao;

	@Override
	public void createHaunter(final Haunter haunter) {
		haunterDao.create(haunter);
	}

	@Override
	public void editHaunter(final Haunter haunter) {
		haunterDao.edit(haunter);
	}

	@Override
	public void removeHaunter(final Haunter haunter) {
		haunterDao.remove(haunter);
	}

	@Override
	public Haunter findById(final Long id) {
		return haunterDao.findById(id);
	}

	@Override
	public Haunter findByName(final String name) {
		return haunterDao.findByName(name);
	}

	@Override
	public List<Haunter> findAll() {
		return haunterDao.findAll();
	}

	@Override
	public List<Haunter> findActiveHaunters() {
		return haunterDao.findActiveHaunters();
	}
}
