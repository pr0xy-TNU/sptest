package services;

import dao.IStudentDao;
import entities.StudentEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentDao studentDao;


    @Transactional(readOnly = true)
    @Override
    public List<StudentEntity> getAll() {
        return studentDao.getAll();
    }

    @Override
    public String getAllDescription() {
        return studentDao.getAllDescription();
    }

    @Override
    public List<StudentEntity> getAllHqlQuery() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentEntity> getAllCriteriaQuery() {
        return studentDao.getAllCriteria();
    }

    @Override
    public StudentEntity findById(int id) {
        return null;
    }

    @Override
    public List<StudentEntity> getStudentsById(int id) {
        return studentDao.getStudentsById(id);
    }
}
