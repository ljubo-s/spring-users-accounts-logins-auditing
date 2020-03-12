package com.spring.users.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.spring.users.model.Person;
import com.spring.users.service.PersonService;
import com.spring.users.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPerson() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

}
