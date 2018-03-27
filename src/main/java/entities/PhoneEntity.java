package entities;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone", schema = "jpa_test_db")
public class PhoneEntity {

    private int phoneId;
    private String phoneModel;
    private String phoneNumber;
    private UserEntity userByUserId;

    @Id
    @Column(name = "phone_id")
    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    @Basic
    @Column(name = "phone_model")
    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneEntity{" +
            "phoneId=" + phoneId +
            ", phoneModel='" + phoneModel + '\t' +
            ", phoneNumber='" + phoneNumber + '\t' +
            '}';
    }

    public PhoneEntity(String phoneModel, String phoneNumber, UserEntity userByUserId) {
        this.phoneModel = phoneModel;
        this.phoneNumber = phoneNumber;
        this.userByUserId = userByUserId;
    }

    public PhoneEntity(String phoneModel, String phoneNumber) {
        this.phoneModel = phoneModel;
        this.phoneNumber = phoneNumber;
    }

    public PhoneEntity() {
        //default
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PhoneEntity that = (PhoneEntity) o;
        return phoneId == that.phoneId &&
            Objects.equals(phoneModel, that.phoneModel) &&
            Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(phoneId, phoneModel, phoneNumber);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
