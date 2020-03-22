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
import com.spring.users.model.Roles;
import com.spring.users.service.RolesService;

@Controller
@RequestMapping(value = "/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("rolesList");
        List<Roles> rolesList = rolesService.getAllRoles();
        model.addObject("rolesList", rolesList);
        return model;
    }

    @RequestMapping(value = "/addRoles/", method = RequestMethod.GET)
    public ModelAndView addRole() {
        ModelAndView model = new ModelAndView("rolesList");
        Roles roles = new Roles();
        model.addObject("rolesForm", roles);
        model.setViewName("rolesForm");
        return model;
    }

    @RequestMapping(value = "/updateRoles/{id}", method = RequestMethod.GET)
    public ModelAndView updateRole(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("rolesList");
        Roles roles = rolesService.getRolesById(id);
        model.addObject("rolesForm", roles);
        model.setViewName("rolesForm");
        return model;
    }

    @RequestMapping(value = "/saveRoles", method = RequestMethod.POST)
    public ModelAndView saveRole(@ModelAttribute("rolesForm") Roles roles) {
        
        try {
            rolesService.saveOrUpdate(roles);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    
        return new ModelAndView("redirect:/roles/list");
    }

    @RequestMapping(value = "/deleteRoles/{id}", method = RequestMethod.GET)
    public ModelAndView deleteRole(@PathVariable("id") Integer id) {
        try {
            rolesService.deleteRoles(id);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return new ModelAndView("redirect:/roles/list");
    }

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        Roles roles = new Roles();
        map.put("roles", roles);
        map.put("rolesList", rolesService.getAllRoles());
        return "roles";
    }

    @RequestMapping(value = "/roles.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Roles roles, BindingResult result, @RequestParam String action, Map<String, Object> map) {

        Roles rolesResult = new Roles();
        Roles searchedRole = new Roles();

        switch (action.toLowerCase()) {

            case "add":
                rolesService.saveOrUpdate(roles);
                rolesResult = roles;
                break;
            case "edit":
                if (roles.getId() != null) {
                    rolesService.saveOrUpdate(roles);
                    rolesResult = roles;
                }
                break;

            case "delete":
                if (roles.getId() != null) {
                    try {
                        rolesService.deleteRoles(roles.getId());
                        rolesResult = new Roles();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;

            case "search":
                if (roles.getId() != null) {
                    searchedRole = rolesService.getRolesById(roles.getId());
                    rolesResult = searchedRole != null ? searchedRole : new Roles();
                }
                break;
        }

        map.put("roles", rolesResult);
        map.put("rolesList", rolesService.getAllRoles());
        return "roles";
    }
}
