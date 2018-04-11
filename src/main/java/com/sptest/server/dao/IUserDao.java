package com.sptest.server.dao;

import com.sptest.server.dao.model.entities.UserEntity;
import java.util.List;

public interface IUserDao {

    void add(UserEntity userEntity);

    List<UserEntity> getAll();

}
