/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dto.AbilityDTO;
import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.facade.PersonFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.PersonService;
import java.util.List;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author petr.melicherik
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class PersonFacadeImplTest extends AbstractTransactionalTestNGSpringContextTests{
    
//    @Autowired
//    private PersonService personService;
//    
    @Autowired
    private PersonFacade personFacade;
    
    @BeforeClass
    public void setupClass() {
        MockitoAnnotations.initMocks(this);
    }
    
    PersonDTO personDTO;
    
    @BeforeMethod
    public void init() {
//        personDTO = new PersonDTO();
//        personDTO.setId((long) 1);
//        personDTO.setEmail("person email");
//        personDTO.setPassword("pass");
//        
//        personFacade.createPerson(personDTO);
    }
    
     @Test
    public void testDataCreation() {
        personDTO = new PersonDTO();
//        personDTO.setId((long) 0);
        personDTO.setEmail("person email");
        personDTO.setPassword("pass");
        
        personFacade.createPerson(personDTO);
        List<PersonDTO> list = personFacade.findAllPersons();
        int a = 5;
//        Assert.assertEquals(personFacade.findPersonById(personDTO.getId()), personDTO);
    }
}
