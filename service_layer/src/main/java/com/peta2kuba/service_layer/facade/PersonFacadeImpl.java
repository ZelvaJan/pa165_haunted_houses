/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dto.PersonAuthenticateDTO;
import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import com.peta2kuba.pa165_haunted_houses.facade.PersonFacade;
import com.peta2kuba.service_layer.BeanMappingService;
import com.peta2kuba.service_layer.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author petr.melicherik
 */
@Service
@Transactional
public class PersonFacadeImpl implements PersonFacade {

    @Autowired
    private PersonService personService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public void createPerson(PersonDTO person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editPerson(PersonDTO person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePerson(PersonDTO person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDTO findById(Long id) {
        Person person = personService.findById(id);
        return (person == null) ? null : beanMappingService.mapTo(person, PersonDTO.class);
    }

    @Override
    public PersonDTO findByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonDTO> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAdmin(PersonDTO person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean authenticate(PersonAuthenticateDTO person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
