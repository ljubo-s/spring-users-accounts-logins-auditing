package com.spring.users.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.spring.users.model.Users;
import com.spring.users.repository.UsersRepository;
import com.spring.users.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) usersRepository.findAll();
    }

    @Override
    public Users getUsersById(Integer id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void deleteUsers(Integer id) {
        usersRepository.deleteById(id);
    }

}
