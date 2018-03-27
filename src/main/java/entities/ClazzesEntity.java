package entities;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clazzes", schema = "jpa_test_db")
public class ClazzesEntity {

    private int clazzId;
    private String clazzName;

    @Id
    @Column(name = "clazz_id")
    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    @Basic
    @Column(name = "clazz_name")
    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClazzesEntity that = (ClazzesEntity) o;
        return clazzId == that.clazzId &&
            Objects.equals(clazzName, that.clazzName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(clazzId, clazzName);
    }
}
