package com.goomez.taskforce.dao;

import com.goomez.taskforce.entity.userEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface userDao extends CrudRepository<userEntity, Integer> {
    @Query(value = "select * from user_entity where email=:email and password=:password and username=:username",nativeQuery = true)
    public userEntity login(String email, String password, String username);
}
