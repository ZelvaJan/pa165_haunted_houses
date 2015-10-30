package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Time;
import java.util.List;

/**
 * @author turcovsky on 29/10/15.
 */
@ContextConfiguration(classes = PersistenceTestAplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class HauntingHoursDaoTest
		extends AbstractTestNGSpringContextTests {

	@Autowired
	private HauntingHoursDao hauntingHoursDao;

	@PersistenceContext
	private EntityManager em;

	@Test
	public void findAll() {
		Long currentTime = System.currentTimeMillis();

		HauntingHours hours = new HauntingHours();
		hours.setFromTime(new Time(currentTime));
		hours.setToTime(new Time(currentTime + 5000));

		HauntingHours hours2 = new HauntingHours();
		hours2.setFromTime(new Time(currentTime - 20000));
		hours2.setToTime(new Time(currentTime));

		hauntingHoursDao.create(hours);
		hauntingHoursDao.create(hours2);

		List<HauntingHours> allHours = hauntingHoursDao.findAll();

		Assert.assertTrue(allHours.size() == 2);

	}

}