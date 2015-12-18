package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dto.PersonAuthenticateDTO;
import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import com.peta2kuba.pa165_haunted_houses.facade.PersonFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.BeanMappingService;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
        personService.createPerson(beanMappingService.mapTo(person, Person.class));
    }

    @Override
    public void editPerson(PersonDTO person) {
        personService.editPerson(beanMappingService.mapTo(person, Person.class));
    }

    @Override
    public void removePerson(PersonDTO person) {
        personService.removePerson(beanMappingService.mapTo(person, Person.class));
    }

    @Override
    public void removePersonById(Long id) {
        personService.removePerson(personService.findPersonById(id));
    }
    
    @Override
    public PersonDTO findPersonById(Long id) {
        Person person = personService.findPersonById(id);
        return (person == null) ? null : beanMappingService.mapTo(person, PersonDTO.class);
    }

    @Override
    public PersonDTO findPersonByEmail(String email) {
        Person person = personService.findPersonByEmail(email);
        return (person == null) ? null : beanMappingService.mapTo(person, PersonDTO.class);
    }

    @Override
    public List<PersonDTO> findAllPersons() {
        return beanMappingService.mapTo(personService.findAllPersons(), PersonDTO.class);
    }

    @Override
    public boolean isAdmin(PersonDTO person) {
        return personService.isAdmin(beanMappingService.mapTo(person, Person.class));
    }

    @Override
    public boolean authenticate(PersonAuthenticateDTO person) {
        return personService.authenticate(person.getEmail(), person.getPassword());
    }

}
