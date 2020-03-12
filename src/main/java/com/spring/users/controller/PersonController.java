package com.spring.users.controller;

import java.util.Map;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.users.model.Users;
import com.spring.users.model.Person;
import com.spring.users.service.PersonService;
import com.spring.users.service.UsersService;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("personList");
        List<Person> personList = personService.getAllPerson();
        model.addObject("personList", personList);
        return model;
    }

    @RequestMapping(value = "/addPerson/", method = RequestMethod.GET)
    public ModelAndView addPerson() {
        ModelAndView model = new ModelAndView("personList");
        Person person = new Person();
        model.addObject("personForm", person);
        model.setViewName("personForm");
        return model;
    }

    @RequestMapping(value = "/updatePerson/{id}", method = RequestMethod.GET)
    public ModelAndView updatePerson(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("personList");
        Person person = personService.getPersonById(id);
        model.addObject("personForm", person);
        model.setViewName("personForm");
        return model;
    }

    @RequestMapping(value = "/savePerson", method = RequestMethod.POST)
    public ModelAndView savePerson(@ModelAttribute("personForm") Person person) {

        try {
            personService.saveOrUpdate(person);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        return new ModelAndView("redirect:/person/list");
    }

    @RequestMapping(value = "/deletePerson/{id}", method = RequestMethod.GET)
    public ModelAndView deletePerson(@PathVariable("id") Integer id) {
        try {
            personService.deletePerson(id);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return new ModelAndView("redirect:/person/list");
    }

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        Person person = new Person();
        map.put("person", person);
        map.put("personList", personService.getAllPerson());
        
        Users users = new Users();
        map.put("users", users);
        map.put("usersList", usersService.getAllUsers());
        
        return "person";
    }

    @RequestMapping(value = "/person.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Person person, BindingResult result, @RequestParam String action, Map<String, Object> map) {

        Person personResult = new Person();
        Person searchedPerson = new Person();

        switch (action.toLowerCase()) {

            case "add":
                personService.saveOrUpdate(person);
                personResult = person;
                break;
            case "edit":
                if (person.getId() != null) {
                    personService.saveOrUpdate(person);
                    personResult = person;
                }
                break;

            case "delete":
                if (person.getId() != null) {
                    try {
                        personService.deletePerson(person.getId());
                        personResult = new Person();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;

            case "search":
                if (person.getId() != null) {
                    searchedPerson = personService.getPersonById(person.getId());
                    personResult = searchedPerson != null ? searchedPerson : new Person();
                }
                break;
        }

        map.put("person", personResult);
        map.put("personList", personService.getAllPerson());
        return "person";
    }
}
