package com.spring.users.controller;

import java.util.ArrayList;
import java.util.List;
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
public class UsersAudController {

    @Autowired
    private UsersAudService usersaudService;
    @Autowired
    private PersonService personService;

    @RequestMapping("/usersaud")
    public String setupForm(Map<String, Object> map) {
        UsersAud usersaud = new UsersAud();
        map.put("usersaud", usersaud);
        map.put("usersaudList", usersaudService.getAllUsersAud());
        map.put("personList", personService.getAllPerson());

        return "usersaud";
    }

    @RequestMapping(value = "/usersaud.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute UsersAud usersaud, BindingResult result,
            @RequestParam String action, Map<String, Object> map) {

        UsersAud usersaudResult = new UsersAud();
        UsersAud searchedUsersAud = new UsersAud();
        List<UsersAud> searchedUsresAudList = new ArrayList<UsersAud>();


        switch (action.toLowerCase()) {

            case "add":
                usersaudService.saveOrUpdate(usersaud);
                usersaudResult = usersaud;

                map.put("usersaud", usersaudResult);
                map.put("usersaudList", usersaudService.getAllUsersAud());
                break;
            
            case "edit":
                if (usersaud.getId() != null) {
                    usersaudService.saveOrUpdate(usersaud);
                    usersaudResult = usersaud;
                }
                map.put("usersaud", usersaudResult);
                map.put("usersaudList", usersaudService.getAllUsersAud());
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
                map.put("usersaud", usersaudResult);
                map.put("usersaudList", usersaudService.getAllUsersAud());
                break;
                
            case "search":
                if (usersaud.getId() != null) {

                    try {
                        searchedUsresAudList =
                                usersaudService.getUsersAudByIdList(usersaud.getId());
                        searchedUsersAud = searchedUsresAudList.get(0);
                    } catch (Exception e) {

                    }
                    usersaudResult = searchedUsersAud != null ? searchedUsersAud : new UsersAud();
                }

                map.put("usersaud", usersaudResult);
                map.put("usersaudList", searchedUsresAudList);
                break;

            case "searchbyrev":
                System.out.println("REV, rev: " + usersaud.getRev());
                if (usersaud.getRev() != null) {

                    try {
                        searchedUsersAud = usersaudService.getUsersAudById(usersaud.getRev());
                        System.out.println("id: " + searchedUsersAud.getId());
                        System.out.println("username: " + searchedUsersAud.getUsername());
                        System.out.println("password: " + searchedUsersAud.getPassword());

                    } catch (Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }

                    usersaudResult = searchedUsersAud != null ? searchedUsersAud : new UsersAud();
                }

                map.put("usersaud", usersaudResult);
                map.put("usersaudList", usersaudService.getAllUsersAud());
                break;
        }

        return "usersaud";
    }

}
