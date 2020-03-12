package com.spring.users.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.users.model.Roles;
import com.spring.users.repository.RolesRepository;
import com.spring.users.service.RolesService;

@Service
@Transactional
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<Roles> getAllRoles() {
        return (List<Roles>) rolesRepository.findAll();
    }

    @Override
    public Roles getRolesById(Integer id) {
        return rolesRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Roles roles) {
        rolesRepository.save(roles);
    }

    @Override
    public void deleteRoles(Integer id) {
        rolesRepository.deleteById(id);
    }

}
