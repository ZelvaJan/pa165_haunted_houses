package com.peta2kuba.pa165_haunted_houses.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.facade.PersonFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Collection;

/**
 * @author turcovsky on 09/12/15.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	final static Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Inject
	private PersonFacade personFacade;


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

	@RequestMapping(value = "/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final PersonDTO getPersonByEmail(@PathVariable("email") String email) throws Exception {

		logger.debug("rest getPersonByEmail({})", email);
		PersonDTO personDTO = personFacade.findPersonByEmail(email);
		if (personDTO == null){
			throw new RuntimeException("Person not found!");
		}
		return personDTO;
	}
}
