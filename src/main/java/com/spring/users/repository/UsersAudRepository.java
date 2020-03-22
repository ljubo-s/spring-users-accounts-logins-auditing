package com.spring.users.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.spring.users.model.UsersAud;

public interface UsersAudRepository extends CrudRepository<UsersAud, Integer> {

    @Query("select u from UsersAud u where u.id=:id")
    List<UsersAud> findByIdList(@Param("id") Integer id);

}
