package com.spring.users.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.users.model.UsersAud;
import com.spring.users.service.PersonService;
import com.spring.users.service.UsersAudService;

@Controller
@RequestMapping(value = "/usersaud")
public class UsersAudController {

    @Autowired
    private UsersAudService usersaudService;
    @Autowired
    private PersonService personService;

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        UsersAud usersaud = new UsersAud();
        map.put("usersaud", usersaud);
        map.put("usersaudList", usersaudService.getAllUsersAud());
        map.put("personList", personService.getAllPerson());
        
        return "usersaud";
    }

    @RequestMapping(value = "/usersaud.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute UsersAud usersaud, BindingResult result, @RequestParam String action, Map<String, Object> map) {

        UsersAud usersaudResult = new UsersAud();
        UsersAud searchedUsersAud = new UsersAud();

        switch (action.toLowerCase()) {

            case "add":
                usersaudService.saveOrUpdate(usersaud);
                usersaudResult = usersaud;
                break;
            case "edit":
                if (usersaud.getId() != null) {
                    usersaudService.saveOrUpdate(usersaud);
                    usersaudResult = usersaud;
                }
                break;
            case "delete":
                if (usersaud.getId() != null) {
                    try {
                        usersaudService.deleteUsersAud(usersaud.getId());
                        usersaudResult = new UsersAud();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;
            case "search":
                if (usersaud.getId() != null) {
                    searchedUsersAud = usersaudService.getUsersAudById(usersaud.getId());
                    usersaudResult = searchedUsersAud != null ? searchedUsersAud : new UsersAud();
                }
                break;
        }

        map.put("usersaud", usersaudResult);
        map.put("usersaudList", usersaudService.getAllUsersAud());
        return "usersaud";
    }

}
