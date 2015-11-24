package com.peta2kuba.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.dao.PersonDao;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link PersonService}. This class is part of the
 * service module of the application that provides the implementation of the
 * business logic.
 *
 * @author petr.melicherik
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public void createPerson(Person person) {
        personDao.create(person);
    }

    @Override
    public void editPerson(Person person) {
        personDao.edit(person);
    }

    @Override
    public void removePerson(Person person) {
        personDao.remove(person);
    }

    @Override
    public Person findPersonById(Long id) {
        return personDao.findById(id);
    }

    @Override
    public Person findPersonByEmail(String email) {
        return personDao.findByEmail(email);
    }

    @Override
    public List<Person> findAllPersons() {
        return personDao.findAll();
    }

    @Override
    public boolean isAdmin(Person person) {
        if (person == null) {
            return false;
        } else {
            return findPersonById(person.getId()).isAdmin();
        }
    }

    @Override
    public boolean authenticate(String email, String passwordHash) {
        Person person = findPersonByEmail(email);
        if (person == null || passwordHash == null) {
            return false;
        } else {
            return passwordHash.equals(person.getPassword());
        }
    }

}
