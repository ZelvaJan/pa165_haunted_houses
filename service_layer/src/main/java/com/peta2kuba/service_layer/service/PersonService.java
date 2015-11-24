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

    Person findPersonById(Long id);

    Person findPersonByEmail(String email);

    /**
     * Find all existing persons in database
     *
     * @return list of existing persons
     */
    List<Person> findAllPersons();

    /**
     * Check if person is admin
     *
     * @param person entity to check
     * @return true if person is admin
     */
    boolean isAdmin(Person person);

    /**
     * Verify if person exist in database and passwords match.
     *
     * @param email email of verifying person
     * @param passwordHash input password
     * @return true if person exist and passwords match
     */
    boolean authenticate(String email, String passwordHash);

}
