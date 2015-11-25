package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author turcovsky on 29/10/15.
 */
@ContextConfiguration(classes = PersistenceTestAplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class PersonDaoTest
		extends AbstractTestNGSpringContextTests {

	@Autowired
	private PersonDao personDao;

	private Person p1;
	private Person p2;

	@BeforeMethod
	public void initPeople() {
		p1 = new Person();
		p1.setEmail("premek@lada.com");
		p1.setPassword("aaaaaa");

		p2 = new Person();
		p2.setEmail("petr@cukrkandl.cz");
		p2.setPassword("AzoreLehni!");

		personDao.create(p1);
		personDao.create(p2);
	}

	/**
	 * Make sure that the creation of database objects work and can return all
	 * ability entries.
	 */
	@Test
	public void findAll() {
		List<Person> people = personDao.findAll();

		Assert.assertTrue(people.size() == 2);
		Assert.assertTrue(people.contains(p1));
		Assert.assertTrue(people.contains(p2));
	}

	/**
	 * Make sure that find object by id work.
	 */
	@Test
	public void findById() {
		Person result = personDao.findById(p1.getId());
		Assert.assertEquals(result, p1);
	}

	/**
	 * Make sure that Person can be found by email
	 */
	@Test
	public void findByEmail() {
		Person result = personDao.findByEmail(p1.getEmail());
		Assert.assertEquals(result, p1);
	}

	/**
	 * Make sure that object is successfully inserted to db and can be removed.
	 */
	@Test()
	public void remove() {
		Assert.assertNotNull(personDao.findById(p1.getId()));
		personDao.remove(p1);
		Assert.assertNull(personDao.findById(p1.getId()));

		personDao.create(p1);
	}

	/**
	 * Make sure that object is successfully inserted to db and can be updated.
	 */
	@Test()
	public void update() {
		Person updated = new Person(p1.getId(), "premek@head.com", "bbbbbb");
		personDao.edit(updated);

		Person result = personDao.findById(p1.getId());

		Assert.assertEquals(result.getEmail(), updated.getEmail());
		Assert.assertEquals(result.getPassword(), updated.getPassword());
	}

	/**
	 * Make sure email address is unique
	 */
	@Test(expectedExceptions = PersistenceException.class)
	public void uniqueEmail() {
		Person person = new Person();
		person.setEmail("notSoUnique@email.com");
		person.setPassword("aaaaaa");

		Person person2 = new Person();
		person2.setEmail("notSoUnique@email.com");
		person2.setPassword("aaaaaa");

		personDao.create(person);
		personDao.create(person2);
	}

	/**
	 * Check non-null name constraints
	 */
	@Test(expectedExceptions = ConstraintViolationException.class)
	public void nullEmail() {
		Person person = new Person();
		person.setEmail(null);
		person.setPassword("aaaaaa");

		personDao.create(person);
	}

	/**
	 * Check non-null name constraints
	 */
	@Test(expectedExceptions = ConstraintViolationException.class)
	public void nullPassword() {
		Person person = new Person();
		person.setEmail("kuba@email.com");
		person.setPassword(null);

		personDao.create(person);
	}
}
