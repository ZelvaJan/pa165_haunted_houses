package com.peta2kuba.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.entity.Person;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * An interface that defines a service access to the {@link Person} entity.
 *
 * @author petr.melicherik
 */
@Service
public interface PersonService {

    void createPerson(Person person);

    void editPerson(Person person);

    void removePerson(Person person);

    Person findById(Long id);

    Person findByEmail(String email);

    List<Person> findAll();

    boolean isAdmin(Person person);

    boolean authenticate(String email, String passwordHash);

}
