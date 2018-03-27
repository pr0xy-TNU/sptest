package entities;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "user", schema = "jpa_test_db")
public class UserEntity {

    @Override
    public String toString() {
        return "UserEntity{" +
            "userId=" + userId +
            ", userName='" + userName + '\t' +
            ", userAge='" + userAge + '\t' +
            ", adress='" + adress + '\t' +
            ", phonesByUserId=" + phonesByUserId +
            "}\n";
    }

    private int userId;
    private String userName;
    private String userAge;
    private String adress;
    private Collection<PhoneEntity> phonesByUserId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_age")
    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    @Basic
    @Column(name = "adress")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
            Objects.equals(userName, that.userName) &&
            Objects.equals(userAge, that.userAge) &&
            Objects.equals(adress, that.adress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, userName, userAge, adress);
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "userByUserId")
    public Collection<PhoneEntity> getPhonesByUserId() {
        return phonesByUserId;
    }

    public void setPhonesByUserId(Collection<PhoneEntity> phonesByUserId) {
        this.phonesByUserId = phonesByUserId;
    }
}
