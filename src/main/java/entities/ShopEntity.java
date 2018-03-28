package entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop", schema = "jpa_test_db")
public class ShopEntity implements Serializable {

    private int shopId;
    private String shopName;
    private String shopAddress;
    private String shopOwner;
    private double shopCustomerDensity;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(value = "id")
    public int getShopId() {
        return shopId;
    }

    @Basic
    @Column(name = "shop_name")
    @JsonProperty(value = "shop_name")
    public String getShopName() {
        return shopName;
    }

    @Basic
    @Column(name = "address")
    @JsonProperty(value = "address")
    public String getShopAddress() {
        return shopAddress;
    }

    @Basic
    @Column(name = "owner")
    @JsonProperty(value = "owner")
    public String getShopOwner() {
        return shopOwner;
    }

    @Basic
    @Column(name = "customers_density")
    @JsonProperty(value = "customers_density")
    public double getShopCustomerDensity() {
        return shopCustomerDensity;
    }

    public ShopEntity() {
        //default
    }

    public ShopEntity(String shopName, String shopAddress, String shopOwner,
        double shopCustomerCount) {
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopOwner = shopOwner;
        this.shopCustomerDensity = shopCustomerCount;
    }

    public ShopEntity(int id, String shopName, String shopAddress, String shopOwner,
        double shopCustomerCount) {
        this(shopName, shopAddress, shopOwner, shopCustomerCount);
        this.shopId = id;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    public void setShopCustomerDensity(double shopCustomerDensity) {
        this.shopCustomerDensity = shopCustomerDensity;
    }

    @Override
    public String toString() {
        String entity = String
            .format("%3d %15s %30s %30s  %10.3f", this.shopId, this.shopName, this.shopAddress,
                this.shopOwner,
                this.shopCustomerDensity);
        return entity;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShopEntity that = (ShopEntity) o;
        return shopId == that.shopId &&
            Objects.equals(shopName, that.shopName) &&
            Objects.equals(shopAddress, that.shopAddress) &&
            Objects.equals(shopOwner, that.shopOwner) &&
            Objects.equals(shopCustomerDensity, that.shopCustomerDensity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shopId, shopName, shopAddress, shopOwner, shopCustomerDensity);
    }
}
