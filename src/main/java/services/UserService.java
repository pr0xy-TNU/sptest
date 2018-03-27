package services;

import dao.IUserDao;
import dao.UserDao;
import entities.UserEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {


    @Autowired
    private IUserDao userDao;

    @Transactional
    @Override
    public void add(UserEntity entity) {
        userDao.add(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserEntity> getAll() {
        return userDao.getAll();
    }
}
