package com.spring.users.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.spring.users.model.UsersRole;
import com.spring.users.repository.UsersRoleRepository;
import com.spring.users.service.UsersRoleService;

@Service
@Transactional
public class UsersRoleServiceImpl implements UsersRoleService {

    @Autowired
    private UsersRoleRepository usersRoleRepository;

    @Override
    public List<UsersRole> getAllUsersRole() {
        return (List<UsersRole>) usersRoleRepository.findAll();
    }

    @Override
    public UsersRole getUsersRoleById(Long id) {
        return usersRoleRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(UsersRole permissionUsers) {
        usersRoleRepository.save(permissionUsers);
    }

    @Override
    public void deleteUsersRole(Long id) {
        usersRoleRepository.deleteById(id);
    }

}
