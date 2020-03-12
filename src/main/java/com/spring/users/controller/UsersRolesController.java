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
import com.spring.users.model.UsersRoles;
import com.spring.users.service.RolesService;
import com.spring.users.service.UsersService;
import com.spring.users.service.UsersRolesService;

@Controller
@RequestMapping(value = "/usersRoles")
public class UsersRolesController {

    @Autowired
    private UsersRolesService usersRolesService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private RolesService rolesService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("usersRolesList");
        List<UsersRoles> usersRolesList = usersRolesService.getAllUsersRoles();
        model.addObject("usersRolesList", usersRolesList);
        return model;
    }

    @RequestMapping(value = "/addUsersRoles/", method = RequestMethod.GET)
    public ModelAndView addUsersRole() {
        ModelAndView model = new ModelAndView("usersRolesList");
        UsersRoles usersRoles = new UsersRoles();
        model.addObject("usersRolesForm", usersRoles);
        model.setViewName("usersRolesForm");
        return model;
    }

    @RequestMapping(value = "/updateUsersRoles/{id}", method = RequestMethod.GET)
    public ModelAndView updateUsersRoles(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("usersRolesList");
        UsersRoles usersRoles = usersRolesService.getUsersRolesById(id);
        model.addObject("usersRolesForm", usersRoles);
        model.setViewName("usersRolesForm");
        return model;
    }

    @RequestMapping(value = "/saveUsersRoles", method = RequestMethod.POST)
    public ModelAndView saveUsersRoles(@ModelAttribute("usersRolesForm") UsersRoles usersRoles) {

        try {
            usersRolesService.saveOrUpdate(usersRoles);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return new ModelAndView("redirect:/usersRoles/list");
    }

    @RequestMapping(value = "/deleteUsersRoles/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUsersRoles(@PathVariable("id") Integer id) {

        try {
            usersRolesService.deleteUsersRoles(id);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        return new ModelAndView("redirect:/usersRoles/list");
    }

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        UsersRoles usersRoles = new UsersRoles();
        
        map.put("usersRoles", usersRoles);
        map.put("usersRolesList", usersRolesService.getAllUsersRoles());
        
        map.put("usersList", usersService.getAllUsers());
        map.put("rolesList", rolesService.getAllRoles());
        
        return "usersRoles";
    }

    @RequestMapping(value = "/usersRoles.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute UsersRoles usersRoles, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        UsersRoles usersRoleResult = new UsersRoles();
        UsersRoles searchedUsersRole = new UsersRoles();

        switch (action.toLowerCase()) {

            case "add":
                usersRolesService.saveOrUpdate(usersRoles);
                usersRoleResult = usersRoles;
                break;
            case "edit":
                if (usersRoles.getId() != null) {
                    usersRolesService.saveOrUpdate(usersRoles);
                    usersRoleResult = usersRoles;
                }
                break;
            case "delete":
                if (usersRoles.getId() != null) {

                    try {
                        usersRolesService.deleteUsersRoles(usersRoles.getId());
                        usersRoleResult = new UsersRoles();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;
            case "search":
                if (usersRoles.getId() != null) {
                    searchedUsersRole = usersRolesService.getUsersRolesById(usersRoles.getId());
                    usersRoleResult = searchedUsersRole != null ? searchedUsersRole : new UsersRoles();
                }
                break;
        }

        map.put("usersRoles", usersRoleResult);
        map.put("usersRolesList", usersRolesService.getAllUsersRoles());
        map.put("usersList", usersService.getAllUsers());
        map.put("rolesList", rolesService.getAllRoles());

        return "usersRoles";
    }

}
