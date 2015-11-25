package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.dao.HouseDao;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link com.peta2kuba.pa165_haunted_houses.service_layer.service.HouseService}. This class is part of the
 * service module of the application that provides the implementation of the
 * business logic.
 *
 * @author skornok on 24/11/15.
 */
@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDao houseDao;

	@Override
	public void createHouse(final House house) {
		houseDao.create(house);
	}

	@Override
	public void editHouse(final House house) {
		houseDao.edit(house);
	}

	@Override
	public void removeHouse(final House house) {
		houseDao.remove(house);
	}

	@Override
	public House findById(final Long id) {
		return houseDao.findById(id);
	}

	@Override
	public List<House> findAll() {
		return houseDao.findAll();
	}

	@Override
	public List<Haunter> findHaunters() {
		return houseDao.findHaunters();
	}
}
