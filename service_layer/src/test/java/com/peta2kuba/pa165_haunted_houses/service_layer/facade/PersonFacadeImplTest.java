/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dao.PersonDao;
import com.peta2kuba.pa165_haunted_houses.dto.PersonAuthenticateDTO;
import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import com.peta2kuba.pa165_haunted_houses.facade.PersonFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.BeanMappingService;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.PersonService;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.PersonServiceImpl;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This Test class is testing methods of {@link PersonFacadeImpl}
 *
 * @author petr.melicherik
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class PersonFacadeImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Mock
    private PersonDao personDao;

    @Autowired
    @InjectMocks
    private PersonService personService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Autowired
    private PersonFacade personFacade;

    Person person;
    Person person2;
    PersonDTO personDTO;
    PersonDTO personDTO2;
    Person personHash;
    PersonDTO personDTOHash;

    @BeforeClass
    public void setupClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void init() {
        person = new Person((long) 0, "prema@podlaha", "pass");
        person.setAdmin(true);
        person2 = new Person((long) 1, "podlaha@podlaha", "aaaa");
        person2.setAdmin(false);
        personDTO = beanMappingService.mapTo(person, PersonDTO.class);
        personDTO2 = beanMappingService.mapTo(person2, PersonDTO.class);

        personDTOHash = new PersonDTO((long) 2, "admin", "admin");
        personDTOHash.setAdmin(true);
        personHash = new Person((long) 2, "admin", PersonServiceImpl.createHash("admin"));
        personHash.setAdmin(true);
    }

    /**
     * Test of create method, of class PersonFacadeImpl.
     */
    @Test
    public void testCreate() {
        personFacade.createPerson(personDTO);
    }

    /**
     * Test of edit method, of class PersonFacadeImpl.
     */
    @Test
    public void testEdit() {
        when(personDao.findById(personDTO.getId())).thenReturn(person);
        personFacade.editPerson(personDTO);
    }

    /**
     * Test of remove method, of class PersonFacadeImpl.
     */
    @Test
    public void testRemove() {
        personFacade.removePerson(personDTO);
        verify(personDao).remove(person);
    }

    /**
     * Test of findById method, of class PersonFacadeImpl.
     */
    @Test
    public void testFindById() {
        when(personDao.findById(person.getId())).thenReturn(person);
        PersonDTO personDTOLoc = personFacade.findPersonById(person.getId());
        Assert.assertEquals(beanMappingService.mapTo(person, PersonDTO.class), personDTOLoc);
    }

    /**
     * Test of findByEmail method, of class PersonFacadeImpl.
     */
    @Test
    public void testFindByEmail() {
        when(personDao.findByEmail(person.getEmail())).thenReturn(person);
        PersonDTO personDTOLoc = personFacade.findPersonByEmail(person.getEmail());
        Assert.assertEquals(beanMappingService.mapTo(person, PersonDTO.class), personDTOLoc);
    }

    /**
     * Test of findAll method, of class PersonFacadeImpl.
     */
    @Test
    public void testFindAll() {
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);

        when(personDao.findAll()).thenReturn(personList);
        List<PersonDTO> newPersonDTOList = personFacade.findAllPersons();
        Assert.assertEquals(beanMappingService.mapTo(personList, PersonDTO.class), newPersonDTOList);
    }

    /**
     * Test of isAdmin method, of class PersonFacadeImpl.
     */
    @Test
    public void testIsAdmin() {
        when(personDao.findById(person.getId())).thenReturn(person);

        Assert.assertEquals(personFacade.isAdmin(personDTO), person.isAdmin());
        Assert.assertNotEquals(personFacade.isAdmin(personDTO), person2.isAdmin());
    }

    /**
     * Test of authenticate method, of class PersonFacadeImpl.
     */
    @Test
    public void testAuthenticate() {
        when(personDao.findByEmail(personHash.getEmail())).thenReturn(personHash);
        PersonAuthenticateDTO personAuthenticateDTO = new PersonAuthenticateDTO();
        personAuthenticateDTO.setEmail(personDTOHash.getEmail());
        personAuthenticateDTO.setPassword(personDTOHash.getPassword());
        Assert.assertTrue(personFacade.authenticate(personAuthenticateDTO));
    }
}
