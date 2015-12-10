package com.peta2kuba.pa165_haunted_houses.mvc.controllers;

import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.facade.PersonFacade;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author skornok
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonFacade personFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("people", personFacade.findAllPersons());
        return "person/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPerson(Model model) {
        model.addAttribute("personCreate", new PersonDTO());
        return "person/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(
            @Valid @ModelAttribute("personCreate") PersonDTO formBean,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes,
            UriComponentsBuilder uriBuilder) {
        logger.debug("create(personCreate={})", formBean);

        //in case of validation error forward back to the the form
        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                logger.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
                logger.trace("FieldError: {}", fe);
            }

            redirectAttributes.addFlashAttribute("errors", bindingResult);
            return "/person/add";
        }
        //create person
        personFacade.createPerson(formBean);
        //report success
        redirectAttributes.addFlashAttribute("alert_success", "Person was created");
        return "redirect:" + uriBuilder.path("/person/list").toUriString();
    }
}
