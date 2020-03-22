package com.spring.users.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.spring.users.model.UsersAud;
import com.spring.users.repository.UsersAudRepository;
import com.spring.users.service.UsersAudService;

@Service
@Transactional
public class UsersAudServiceImpl implements UsersAudService {

    @Autowired
    private UsersAudRepository usersAudRepository;

    @Override
    public List<UsersAud> getAllUsersAud() {
        return (List<UsersAud>) usersAudRepository.findAll();
    }

    @Override
    public UsersAud getUsersAudById(Integer id) {
        return usersAudRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(UsersAud users) {
        usersAudRepository.save(users);
    }

    @Override
    public void deleteUsersAud(Integer id) {
        usersAudRepository.deleteById(id);
    }

    @Override
    public List<UsersAud> getUsersAudByIdList(Integer id) {
             return usersAudRepository.findByIdList(id); 
    }

}
