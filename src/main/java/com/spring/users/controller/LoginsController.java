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
import com.spring.users.model.Logins;
import com.spring.users.service.UsersService;
import com.spring.users.service.LoginsService;

@Controller
@RequestMapping(value = "/logins")
public class LoginsController {

    @Autowired
    private LoginsService loginsService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("loginsList");
        List<Logins> loginsList = loginsService.getAllLogins();
        model.addObject("loginsList", loginsList);
        return model;
    }

    @RequestMapping(value = "/addLogins/", method = RequestMethod.GET)
    public ModelAndView addLogins() {
        ModelAndView model = new ModelAndView("loginsList");
        Logins logins = new Logins();
        model.addObject("loginsForm", logins);
        model.setViewName("loginsForm");
        return model;
    }

    @RequestMapping(value = "/updateLogins/{id}", method = RequestMethod.GET)
    public ModelAndView updateLogins(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("loginsList");
        Logins logins = loginsService.getLoginsById(id);
        model.addObject("loginsForm", logins);
        model.setViewName("loginsForm");
        return model;
    }

    @RequestMapping(value = "/saveLogins", method = RequestMethod.POST)
    public ModelAndView saveLogins(@ModelAttribute("loginsForm") Logins logins) {

        try {
            loginsService.saveOrUpdate(logins);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        return new ModelAndView("redirect:/logins/list");
    }

    @RequestMapping(value = "/deleteLogins/{id}", method = RequestMethod.GET)
    public ModelAndView deleteLogins(@PathVariable("id") Long id) {
        try {
            loginsService.deleteLogins(id);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return new ModelAndView("redirect:/logins/list");
    }

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        Logins logins = new Logins();
        map.put("logins", logins);
        map.put("loginsList", loginsService.getAllLogins());
        
        Users users = new Users();
        map.put("users", users);
        map.put("usersList", usersService.getAllUsers());
        
        return "logins";
    }

    @RequestMapping(value = "/logins.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Logins logins, BindingResult result, @RequestParam String action, Map<String, Object> map) {

        Logins loginsResult = new Logins();
        Logins searchedLogins = new Logins();

        switch (action.toLowerCase()) {

            case "add":
                loginsService.saveOrUpdate(logins);
                loginsResult = logins;
                break;
            case "edit":
                if (logins.getId() != null) {
                    loginsService.saveOrUpdate(logins);
                    loginsResult = logins;
                }
                break;

            case "delete":
                if (logins.getId() != null) {
                    try {
                        loginsService.deleteLogins(Long.valueOf(logins.getId()));
                        loginsResult = new Logins();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;

            case "search":
                if (logins.getId() != null) {
                    searchedLogins = loginsService.getLoginsById(Long.valueOf(logins.getId()));
                    loginsResult = searchedLogins != null ? searchedLogins : new Logins();
                }
                break;
        }

        map.put("logins", loginsResult);
        map.put("loginsList", loginsService.getAllLogins());
        return "logins";
    }
}
