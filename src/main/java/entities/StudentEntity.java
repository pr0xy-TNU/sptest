package entities;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", schema = "jpa_test_db")
public class StudentEntity {

    private int studentId;
    private String studentName;

    @Id
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "student_name")
    public String getStudentName() {
        return studentName;
    }

    public StudentEntity(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public StudentEntity() {
        //default
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentEntity that = (StudentEntity) o;
        return studentId == that.studentId &&
            Objects.equals(studentName, that.studentName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, studentName);
    }
}
