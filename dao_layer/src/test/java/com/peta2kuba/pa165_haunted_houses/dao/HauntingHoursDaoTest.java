package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
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
import javax.validation.ConstraintViolationException;
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

	/**
	 * Make sure that the creation of database objects work and can return all
	 * ability entries.
	 */
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
		Assert.assertTrue(allHours.contains(hours));
		Assert.assertTrue(allHours.contains(hours2));

	}

	/**
	 * Make sure that find object by id work.
	 */
	@Test
	public void findById() {
		Long currentTime = System.currentTimeMillis();

		HauntingHours hours = new HauntingHours();
		hours.setFromTime(new Time(currentTime));
		hours.setToTime(new Time(currentTime + 1));

		HauntingHours hours2 = new HauntingHours();
		hours2.setFromTime(new Time(currentTime));
		hours2.setToTime(new Time(currentTime + 1));

		hauntingHoursDao.create(hours);
		hauntingHoursDao.create(hours2);

		HauntingHours result = hauntingHoursDao.findById(hours2.getId());
		Assert.assertEquals(result, hours2);
	}

	/**
	 * Make sure that object is successfully inserted to db and can be removed.
	 */
	@Test()
	public void remove() {
		HauntingHours hours = new HauntingHours();
		hours.setFromTime(Time.valueOf("07:00:02"));
		hours.setToTime(Time.valueOf("19:00:01"));

		hauntingHoursDao.create(hours);

		Assert.assertNotNull(hauntingHoursDao.findById(hours.getId()));
		hauntingHoursDao.remove(hours);
		Assert.assertNull(hauntingHoursDao.findById(hours.getId()));
	}

	/**
	 * Make sure that object is successfully inserted to db and can be updated.
	 */
	@Test()
	public void update() {
		Long currentTime = System.currentTimeMillis();

		HauntingHours hours = new HauntingHours();
		hours.setFromTime(new Time(currentTime));
		hours.setToTime(new Time(currentTime + 1));

		hauntingHoursDao.create(hours);

		HauntingHours updated = new HauntingHours(hours.getId(), Time.valueOf("07:00:02"), Time.valueOf("19:00:01"));
		hauntingHoursDao.edit(updated);

		HauntingHours result = hauntingHoursDao.findById(hours.getId());

		Assert.assertEquals(result.getFromTime(), updated.getFromTime());
		Assert.assertEquals(result.getToTime(), updated.getToTime());
	}

	/**
	 * Check non-null name constraints
	 */
	@Test(expectedExceptions = ConstraintViolationException.class)
	public void nullFromTime() {
		HauntingHours hours = new HauntingHours();
		hours.setFromTime(null);
		hours.setToTime(new Time(System.currentTimeMillis()));

		hauntingHoursDao.create(hours);
	}

	/**
	 * Check non-null name constraints
	 */
	@Test(expectedExceptions = ConstraintViolationException.class)
	public void nullToTime() {
		HauntingHours hours = new HauntingHours();
		hours.setFromTime(new Time(System.currentTimeMillis()));
		hours.setToTime(null);

		hauntingHoursDao.create(hours);
	}

}