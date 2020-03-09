package com.spring.users.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.spring.users.model.Logins;
import com.spring.users.service.LoginsService;
import com.spring.users.repository.LoginsRepository;

@Service
@Transactional
public class LoginsServiceImpl implements LoginsService {

    @Autowired
    private LoginsRepository loginsRepository;

    @Override
    public List<Logins> getAllLogins() {
        return (List<Logins>) loginsRepository.findAll();
    }

    @Override
    public Logins getLoginsById(Long id) {
        return loginsRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Logins logins) {
        loginsRepository.save(logins);
    }

    @Override
    public void deleteLogins(Long id) {
        loginsRepository.deleteById(id);
    }

}
