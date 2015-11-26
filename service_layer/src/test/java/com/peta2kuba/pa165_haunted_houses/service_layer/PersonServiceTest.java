package com.peta2kuba.pa165_haunted_houses.service_layer;

import com.peta2kuba.pa165_haunted_houses.dao.PersonDao;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.PersonService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author turcovsky on 26/11/15.
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class PersonServiceTest extends AbstractTransactionalTestNGSpringContextTests {

	@Mock
	private PersonDao personDao;

	@Autowired
	@InjectMocks
	private PersonService personService;

	private Person p1;
	private Person p2;

	@BeforeClass
	public void setupClass() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeMethod
	public void init() {
		p1 = new Person();
		p1.setEmail("turcovsky@master.cz");
		p1.setPassword("aaaaaa");
		p1.setAdmin(true);

		p2 = new Person();
		p2.setEmail("hnidopich@zapadakov.cz");
		p2.setPassword("secure");
		p2.setAdmin(false);
	}

	@Test
	public void createPersonTest() {
		personService.createPerson(p1);

		verify(personDao).create(p1);
		verifyNoMoreInteractions(personDao);
	}

	@Test
	public void editPersonTest() {
		personService.createPerson(p1);

		verify(personDao).create(p1);

		p1.setPassword("bbbbbb");
		personService.editPerson(p1);

		verify(personDao).edit(p1);
		verifyNoMoreInteractions(personDao);
	}

	@Test
	public void removePersonTest() {
		personService.createPerson(p1);

		verify(personDao).create(p1);

		personService.removePerson(p1);
		verify(personDao).remove(p1);
	}
}
