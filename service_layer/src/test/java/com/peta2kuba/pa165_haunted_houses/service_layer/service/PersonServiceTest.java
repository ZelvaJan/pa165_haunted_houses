package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.dao.PersonDao;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class of {
 *
 * @PersonServiceImpl}'s methods
 *
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

    private Person personHash;

    @BeforeClass
    public void setupClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void init() {
        p1 = new Person();
        p1.setId((long) 0);
        p1.setEmail("turcovsky@master.cz");
        p1.setPassword("aaaaaa");
        p1.setAdmin(true);

        p2 = new Person();
        p2.setId((long) 1);
        p2.setEmail("hnidopich@zapadakov.cz");
        p2.setPassword("secure");
        p2.setAdmin(false);

        personHash = new Person((long) 2, "admin@email", PersonServiceImpl.createHash("admin"));
        personHash.setAdmin(true);
    }

    /**
     * Simple test for function proclamation.
     */
    @Test
    public void createPersonTest() {
        personService.createPerson(p1);
        verify(personDao).create(p1);
    }

    /**
     * Test return values for isAdmin method.
     */
    @Test
    public void isAdminTest() {
        Assert.assertFalse(personService.isAdmin(null));
        when(personService.findPersonById((long) 0)).thenReturn(p1);
        Assert.assertTrue(personService.isAdmin(p1));
        when(personService.findPersonById((long) 1)).thenReturn(p2);
        Assert.assertFalse(personService.isAdmin(p2));
    }

    /**
     * Test return values for anuthenticate method.
     */
    @Test
    public void authenticateTest() {
        when(personService.findPersonByEmail(personHash.getEmail())).thenReturn(personHash);
        Assert.assertTrue(personService.authenticate(personHash.getEmail(), "admin"));
    }

    /**
     * Test return values (null user in db) for anuthenticate method.
     */
    @Test
    public void authenticateTestNullUser() {
        when(personService.findPersonByEmail(personHash.getEmail())).thenReturn(null);
        Assert.assertFalse(personService.authenticate(personHash.getEmail(), "admin"));
    }
}
