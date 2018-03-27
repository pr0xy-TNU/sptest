package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

public class StudentClazzesEntityPK implements Serializable {

    private int studentId;
    private int clazzId;

    @Column(name = "student_id")
    @Id
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Column(name = "clazz_id")
    @Id
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
        StudentClazzesEntityPK that = (StudentClazzesEntityPK) o;
        return studentId == that.studentId &&
            clazzId == that.clazzId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, clazzId);
    }
}
