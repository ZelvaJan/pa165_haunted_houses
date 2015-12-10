package com.peta2kuba.pa165_haunted_houses.mvc.controllers;

import com.peta2kuba.pa165_haunted_houses.dto.HouseDTO;
import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.facade.AbilityFacade;
import com.peta2kuba.pa165_haunted_houses.facade.HouseFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.validation.Valid;

/**
 * @author turcovsky on 10/12/15.
 */
@Controller
@RequestMapping("/house")
public class HouseController {

	final static Logger logger = LoggerFactory.getLogger(AbilityController.class);

	@Autowired
	private HouseFacade houseFacade;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("houses", houseFacade.findAll());
		return "house/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addHouse(Model model) {
		model.addAttribute("houseCreate", new HouseDTO());
		return "house/add";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("houseCreate") HouseDTO formBean, BindingResult bindingResult,
						 Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
		logger.debug("create(houseCreate={})", formBean);
		//in case of validation error forward back to the the form
		if (bindingResult.hasErrors()) {
			for (ObjectError ge : bindingResult.getGlobalErrors()) {
				logger.trace("ObjectError: {}", ge);
			}
			for (FieldError fe : bindingResult.getFieldErrors()) {
				model.addAttribute(fe.getField() + "_error", true);
				logger.trace("FieldError: {}", fe);
			}
			return "person/add";
		}
		//create person
		houseFacade.createHouse(formBean);
		//report success
		redirectAttributes.addFlashAttribute("alert_success", "House was created");
		return "redirect:" + uriBuilder.path("/house/list").toUriString();
	}

}