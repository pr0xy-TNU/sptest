package com.sptest.server.dao.model.dto;


import com.sun.istack.internal.NotNull;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "login")
    private String login;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "last_data_enter")
    private Long lastDataEnter;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "player_id")
    private PlayerDTO playerDTO;

    public AccountDTO(String login, String password, Long lastDataEnter,
        PlayerDTO playerDTO) {
        this.login = login;
        this.password = password;
        this.lastDataEnter = lastDataEnter;
        this.playerDTO = playerDTO;
    }

    public AccountDTO(String password, Long lastDataEnter,
        PlayerDTO playerDTO) {
        this.password = password;
        this.lastDataEnter = lastDataEnter;
        this.playerDTO = playerDTO;
    }

    public AccountDTO(String login, String password, Long lastDataEnter) {
        this.login = login;
        this.password = password;
        this.lastDataEnter = lastDataEnter;
    }

    public AccountDTO() {
        //default
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getLastDataEnter() {
        return lastDataEnter;
    }

    public void setLastDataEnter(Long lastDataEnter) {
        this.lastDataEnter = lastDataEnter;
    }

    public PlayerDTO getPlayerDTO() {
        return playerDTO;
    }

    public void setPlayerDTO(PlayerDTO playerDTO) {
        this.playerDTO = playerDTO;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
            "id=" + id +
            ", login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", lastDataEnter=" + lastDataEnter +
            ", playerDTO=" + playerDTO +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccountDTO)) {
            return false;
        }
        AccountDTO that = (AccountDTO) o;
        return id == that.id &&
            Objects.equals(login, that.login) &&
            Objects.equals(password, that.password) &&
            Objects.equals(lastDataEnter, that.lastDataEnter);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, lastDataEnter);
    }
}
