package com.peta2kuba.pa165_haunted_houses.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.facade.PersonFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.util.Collection;

/**
 * @author turcovsky on 09/12/15.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

	final static Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Inject
	private PersonFacade personFacade;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final PersonDTO addPerson(@RequestBody PersonDTO person) throws Exception {

		logger.debug("rest addPerson()");

		personFacade.createPerson(person);
		return person;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final void removePerson(@PathVariable("id") long id) throws Exception {
		logger.debug("rest removePerson({})", id);

		personFacade.removePersonById(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Collection<PersonDTO> getPeople() throws JsonProcessingException {

		logger.debug("rest getUsers()");
		return personFacade.findAllPersons();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final PersonDTO getPersonById(@PathVariable("id") long id) throws Exception {

		logger.debug("rest getPersonById({})", id);
		PersonDTO personDTO = personFacade.findPersonById(id);
		if (personDTO == null){
			throw new RuntimeException("Person not found!");
		}
		return personDTO;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public final PersonDTO editPerson(@PathVariable("id") long id, @RequestBody PersonDTO person) {
		System.out.println("Updating User " + id);

		PersonDTO current = personFacade.findPersonById(id);

		current.setEmail(person.getEmail());
		current.setPassword(person.getPassword());
		current.setAdmin(person.isAdmin());

		personFacade.editPerson(current);

		return current;
	}
}
