package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.PersonAuthenticateDTO;
import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;

import java.util.List;

/**
 * @author skornok
 */
public interface PersonFacade {

    void createPerson(PersonDTO person);

    void editPerson(PersonDTO person);

    void removePerson(PersonDTO person);

    void removePersonById(Long id);

    PersonDTO findPersonById(Long id);

    PersonDTO findPersonByEmail(String email);

    List<PersonDTO> findAllPersons();

    /**
     * Check if person is admin
     *
     * @param person entity to check
     * @return true if person is admin
     */
    boolean isAdmin(PersonDTO person);

    /**
     * Verify if person exist in database and passwords match.
     *
     * @param person person for verify
     * @return true if person exist and passwords match
     */
    boolean authenticate(PersonAuthenticateDTO person);

}
