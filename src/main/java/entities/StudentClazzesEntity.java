package entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "StudentClazzes", schema = "jpa_test_db")
@IdClass(StudentClazzesEntityPK.class)
public class StudentClazzesEntity {

    private int studentId;
    private int clazzId;

    @Id
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "clazz_id")
    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentClazzesEntity that = (StudentClazzesEntity) o;
        return studentId == that.studentId &&
            clazzId == that.clazzId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, clazzId);
    }
}
