package services;

import entities.StudentEntity;
import java.util.List;

public interface IStudentService {
    List<StudentEntity> getAll();
    String getAllDescription();
    List<StudentEntity> getAllHqlQuery();
    List<StudentEntity> getAllCriteriaQuery();
    StudentEntity findById(int id);
    List<StudentEntity> getStudentsById(int id);

}
