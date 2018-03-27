package dao;

import com.mysql.cj.api.x.Collection;
import entities.UserEntity;
import java.util.List;

public interface IUserDao {

    void add(UserEntity userEntity);

    List<UserEntity> getAll();

}
