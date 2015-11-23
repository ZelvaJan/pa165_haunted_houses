package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;

import java.util.List;

/**
 * @author skornok
 */
public interface PersonFacade {

    void createPerson(PersonDTO person);

    void editPerson(PersonDTO person);

    void removePerson(PersonDTO person);

    PersonDTO findById(Long id);

    PersonDTO findByEmail(String email);

    List<PersonDTO> findAll();

    boolean isAdmin(PersonDTO person);

    boolean authenticate(String email, String passwordHash);

}
