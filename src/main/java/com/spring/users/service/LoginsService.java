package com.spring.users.service;

import java.util.List;
import com.spring.users.model.Logins;

public interface LoginsService {

    public List<Logins> getAllLogins();

    public Logins getLoginsById(Long id);

    public void saveOrUpdate(Logins logins);

    public void deleteLogins(Long id);

}
