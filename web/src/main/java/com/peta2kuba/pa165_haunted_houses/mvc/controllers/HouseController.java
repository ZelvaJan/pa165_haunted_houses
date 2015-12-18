package com.peta2kuba.pa165_haunted_houses.mvc.controllers;

import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;
import com.peta2kuba.pa165_haunted_houses.dto.HouseDTO;
import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.facade.HaunterFacade;
import com.peta2kuba.pa165_haunted_houses.facade.HouseFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author turcovsky on 10/12/15.
 */
@Controller
@RequestMapping("/house")
public class HouseController {

    final static Logger logger = LoggerFactory.getLogger(HouseController.class);

    @Autowired
    private HouseFacade houseFacade;

    @Autowired
    private HaunterFacade haunterFacade;

    @InitBinder
    public void binder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class,
                new PropertyEditorSupport() {
                    public void setAsText(String value) {
                        try {
                            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value);
                            setValue(new Timestamp(parsedDate.getTime()));
                        } catch (ParseException e) {
                            setValue(null);
                        }
                    }
                });
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("houses", houseFacade.findAll());
        return "house/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String houseById(@PathVariable long id, Model model) {
        model.addAttribute("house", houseFacade.findById(id));
        return "house/detail";
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
            return "house/add";
        }
        //create person
        houseFacade.createHouse(formBean);
        //report success
        redirectAttributes.addFlashAttribute("alert_success", "House was created");
        return "redirect:" + uriBuilder.path("/house/list").toUriString();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPerson(@PathVariable long id, Model model) {
        HouseDTO house = houseFacade.findById(id);
        model.addAttribute("house", house);
        List<HaunterDTO> haunterDTOList = haunterFacade.findAll();
        model.addAttribute("haunters", haunterDTOList);
        return "house/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editPerson(@ModelAttribute("house") HouseDTO newHouse,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes,
            UriComponentsBuilder uriBuilder,
            @PathVariable long id) {

        HouseDTO house = houseFacade.findById(id);

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
            return "/house/edit";
        }
        if (newHouse.getHauntedSince() == null) {
            logger.error("hauntedSince ParseError!!!");
			//model.addAttribute(bindingResult. + "_error", true);
            // TODO set field error

        }

        houseFacade.editHouse(newHouse);
        redirectAttributes.addFlashAttribute("alert_success", "House was edited");
        return "redirect:" + uriBuilder.path("/house/list").toUriString();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id,
            Model model,
            UriComponentsBuilder uriBuilder,
            RedirectAttributes redirectAttributes) {
        HouseDTO house = houseFacade.findById(id);
        if (house != null) {
            houseFacade.removeHouseById(id);
        }
        redirectAttributes.addFlashAttribute("alert_success", "House \"" + house.getName()+ "\" was deleted.");
        return "redirect:" + uriBuilder.path("/house/list").toUriString();
    }
}
