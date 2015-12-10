package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.dao.HauntingHoursDao;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author turcovsky on 10/12/15.
 */
@Service
public class HauntingHoursServiceImpl implements HauntingHoursService {

	@Autowired
	private HauntingHoursDao hauntingHoursDao;

	@Override
	public void createHauntingHours(final HauntingHours hh) {
		hauntingHoursDao.create(hh);
	}
}
