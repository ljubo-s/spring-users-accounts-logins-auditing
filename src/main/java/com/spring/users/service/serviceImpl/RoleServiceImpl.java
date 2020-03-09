package com.spring.users.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.users.model.Role;
import com.spring.users.repository.RoleRepository;
import com.spring.users.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository rollRepository;

    @Override
    public List<Role> getAllRole() {
        return (List<Role>) rollRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return rollRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Role roll) {
        rollRepository.save(roll);
    }

    @Override
    public void deleteRole(Long id) {
        rollRepository.deleteById(id);
    }

}
