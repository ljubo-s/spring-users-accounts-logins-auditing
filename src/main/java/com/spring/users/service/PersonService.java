package com.spring.users.service;

import java.util.List;
import com.spring.users.model.Person;

public interface PersonService {

    public List<Person> getAllPerson();

    public Person getPersonById(Long id);

    public void saveOrUpdate(Person person);

    public void deletePerson(Long id);

}
