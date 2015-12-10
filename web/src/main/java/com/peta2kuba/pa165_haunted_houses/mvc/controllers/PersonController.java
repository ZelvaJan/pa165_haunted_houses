package com.peta2kuba.pa165_haunted_houses.mvc.controllers;


import com.peta2kuba.pa165_haunted_houses.facade.PersonFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("users", personFacade.findAllPersons());
        return "person/list";
    }
}