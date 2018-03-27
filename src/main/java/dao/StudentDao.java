package dao;

import entities.StudentEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import utils.Utils;
import utils.Utils.StudentTable;


@Repository
public class StudentDao implements IStudentDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<StudentEntity> getAll() {
        List list;
        CriteriaQuery<StudentEntity> query = manager.getCriteriaBuilder()
            .createQuery(StudentEntity.class);
        Root<StudentEntity> root = query.from(StudentEntity.class);
        list = manager.createQuery(query).getResultList();
        return list;

    }

    @Override
    public String getAllDescription() {
        List<Object[]> list;
        String nativeQuery = "SELECT s.student_name, cz.clazz_name\n"
            + "FROM StudentClazzes AS stcz\n"
            + "INNER JOIN student s ON stcz.student_id = s.student_id\n"
            + "INNER JOIN clazzes cz ON stcz.clazz_id = cz.clazz_id";
        Query query1 = manager.createNativeQuery(nativeQuery);
        list = query1.getResultList();
        return convert(list);
    }

    @Override
    public String getAllHqlQuery() {
        Session session;
        Criteria criteria;
        session = manager.unwrap(Session.class);

        return null;
    }

    @Override
    public List<StudentEntity> getAllCriteria() {
        Session session;
        Criteria criteria;
        session = manager.unwrap(Session.class);
        criteria = session.getSession().createCriteria(StudentEntity.class);
        List list = criteria.list();
        return list;
    }

    @Override
    public StudentEntity findById(int id) {
        /*Session session;
        Criteria criteria;
        session = manager.unwrap(Session.class);
        criteria = session.getSession().createCriteria(StudentEntity.class);
        Projection projections = Projections.projectionList()
            .add(Projections.property("student_id"))
            .add(Projections.property("student_name"));
        criteria.setProjection(projections);
        criteria.add(Restrictions.eq("student_id", id));*/
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentEntity> getStudentsById(int id) {
        Session session;
        Criteria criteria;
        session = manager.unwrap(Session.class);
        criteria = session.getSession().createCriteria(StudentEntity.class);
        Projection projections = Projections.projectionList()
            .add(Projections.property(StudentTable.STUDENT_ID))
            .add(Projections.property(StudentTable.STUDENT_NAME));
        criteria.setProjection(projections);
        //criteria.add(Restrictions.eq("student_name", id));
        List<StudentEntity> tempList = new ArrayList<>();
        @SuppressWarnings("unchecked")
        List<Object[]> result = criteria.list();
        for (Object[] objects : result
        ) {
            int tempId = (int) objects[0];
            String tempName = (String) objects[1];
            tempList.add(new StudentEntity(tempId, tempName));
        }
        return tempList;
    }

    String convert(List<Object[]> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i)[0]);
            stringBuilder.append(" : ");
            stringBuilder.append(list.get(i)[1]);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    /*List<Object[]> list;
        String hqlQuery = "SELECT s.student_name\n"
            + "FROM StudentClazzes as stcz\n"
            + "INNER JOIN student as s WHERE stcz.student_id = s.student_id";
        Query query1 = manager.createQuery(hqlQuery);
        list = query1.getResultList();
        return convert(list);*/
}
