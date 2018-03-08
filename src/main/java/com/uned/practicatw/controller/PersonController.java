package com.uned.practicatw.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uned.practicatw.entity.Persona;
import com.uned.practicatw.service.PersonaService;

@Controller
@RequestMapping("/person")
public class PersonController {
    protected static final int DEFAULT_PAGE_NUM = 0;
    protected static final int DEFAULT_PAGE_SIZE = 5;

    @Inject
    protected PersonaService personaService;

    protected static final Logger LOGGER = LoggerFactory
            .getLogger(PersonController.class);

    @RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "page", required = false) Integer page,
            Model model) {
        int pageNum = page != null ? page : DEFAULT_PAGE_NUM;
        Page<Persona> paging = personaService.findAll(pageNum, DEFAULT_PAGE_SIZE);
        model.addAttribute("page", paging);
        return "/person/list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public @ModelAttribute
    Persona create(Model model) {
        Persona person = new Persona();
        return person;
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String createOnSubmit(@Valid Persona person,
            BindingResult bindingResult, Model model) {
        LOGGER.debug("create person={}", person);
        if (bindingResult.hasErrors()) {
            LOGGER.warn("validation error={}", bindingResult.getModel());
            model.addAllAttributes(bindingResult.getModel());
            return "/person/form";
        }
        personaService.insert(person);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Model model) {
        Persona person = personaService.findById(id);
        model.addAttribute(person);
        return "/person/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editOnSubmit(@Valid Persona person,
            BindingResult bindingResult, Model model) {
        LOGGER.debug("edit person={}", person);
        if (bindingResult.hasErrors()) {
            LOGGER.warn("validation error={}", bindingResult.getModel());
            model.addAllAttributes(bindingResult.getModel());
            return "/person/form";
        }
        personaService.update(person);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(
            @RequestParam(value = "page", required = false) Integer page,
            @PathVariable("id") Integer id) {
        LOGGER.debug("delete id={}", id);
        personaService.deleteById(id);

        return "redirect:/person/list";
    }

}
