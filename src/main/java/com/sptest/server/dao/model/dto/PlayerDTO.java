package com.sptest.server.dao.model.dto;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "player")
public class PlayerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private int id;

    @Basic
    @Column(name = "player_address")
    private String address;

    @Basic
    @Column(name = "player_age")
    private int age;

    @Basic
    @Column(name = "player_name")
    private String name;

    @Basic
    @Column(name = "player_email")
    private String email;

    @OneToMany(mappedBy = "playerDTO", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<AccountDTO> accounts = new HashSet<>();

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<GameDTO> games = new HashSet<>();


    public PlayerDTO(String address, int age, String name, String email) {
        this.address = address;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public PlayerDTO(int id, String address, int age, String name, String email) {
        this.address = address;
        this.age = age;
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public PlayerDTO() {
        //default
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountDTO> accounts) {
        this.accounts = accounts;
    }

    public Set<GameDTO> getGames() {
        return games;
    }

    public void setGames(Set<GameDTO> gameDTOSet) {
        this.games = gameDTOSet;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
            "id=" + id +
            ", address='" + address + '\'' +
            ", age=" + age +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlayerDTO)) {
            return false;
        }
        PlayerDTO playerDTO = (PlayerDTO) o;
        return id == playerDTO.id &&
            age == playerDTO.age &&
            Objects.equals(address, playerDTO.address) &&
            Objects.equals(name, playerDTO.name) &&
            Objects.equals(email, playerDTO.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, address, age, name, email);
    }
}
