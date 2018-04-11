package com.sptest.server.services;

import com.sptest.server.dao.model.entities.UserEntity;
import java.util.List;

public interface IUserService {

    void add(UserEntity entity);

    List<UserEntity> getAll();

}
