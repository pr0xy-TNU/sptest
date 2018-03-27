package dao;

import entities.StudentEntity;
import java.util.List;

public interface IStudentDao {
    List<StudentEntity> getAll();
    String getAllDescription();
    String getAllHqlQuery();
    List<StudentEntity> getAllCriteria();
    StudentEntity findById(int id);
    List<StudentEntity> getStudentsById(int id);
}
