package services;

import entities.UserEntity;
import java.util.List;

public interface IUserService {

    void add(UserEntity entity);

    List<UserEntity> getAll();

}
