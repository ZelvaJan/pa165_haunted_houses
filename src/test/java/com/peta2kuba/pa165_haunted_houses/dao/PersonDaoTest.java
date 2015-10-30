package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
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

	@Test
	public void findAll() {
		Person person = new Person();
		person.setEmail("premek@lada.com");
		person.setPassword("aaaaaa");

		Person person2 = new Person();
		person2.setEmail("petr@cukrkandl.cz");
		person2.setEmail("AzoreLehni!");

		personDao.create(person);
		personDao.create(person2);

		List<Person> people = personDao.findAll();

		Assert.assertEquals(2, people.size());
	}

}
