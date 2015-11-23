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

	@PersistenceContext
	private EntityManager em;

	/**
	 * Make sure that the creation of database objects work and can return all
	 * ability entries.
	 */
	@Test
	public void findAll() {
		Person person = new Person();
		person.setEmail("premek@lada.com");
		person.setPassword("aaaaaa");

		Person person2 = new Person();
		person2.setEmail("petr@cukrkandl.cz");
		person2.setPassword("AzoreLehni!");

		personDao.create(person);
		personDao.create(person2);

		List<Person> people = personDao.findAll();

		Assert.assertTrue(people.size() == 2);
		Assert.assertTrue(people.contains(person));
		Assert.assertTrue(people.contains(person2));
	}

	/**
	 * Make sure that find object by id work.
	 */
	@Test
	public void findById() {
		Person person = new Person();
		person.setEmail("premek@lada.com");
		person.setPassword("aaaaaa");

		Person person2 = new Person();
		person2.setEmail("petr@cukrkandl.cz");
		person2.setPassword("AzoreLehni!");

		personDao.create(person);
		personDao.create(person2);

		Person result = personDao.findById(person.getId());
		Assert.assertEquals(result, person);
	}

	/**
	 * Make sure that object is successfully inserted to db and can be removed.
	 */
	@Test()
	public void remove() {
		Person person = new Person();
		person.setEmail("premek@lada.com");
		person.setPassword("aaaaaa");

		personDao.create(person);

		Assert.assertNotNull(personDao.findById(person.getId()));
		personDao.remove(person);
		Assert.assertNull(personDao.findById(person.getId()));
	}

	/**
	 * Make sure that object is successfully inserted to db and can be updated.
	 */
	@Test()
	public void update() {
		Person person = new Person();
		person.setEmail("premek@lada.com");
		person.setPassword("aaaaaa");

		personDao.create(person);

		Person updated = new Person(person.getId(), "premek@head.com", "bbbbbb");
		personDao.edit(updated);

		Person result = personDao.findById(person.getId());

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
