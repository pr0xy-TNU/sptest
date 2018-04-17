package com.sptest.server.dao.model.dto;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class GameDTO {

    @Id
    @GeneratedValue
    @Column(name = "game_id")
    private int id;

    @Basic
    @Column(name = "game_name")
    private String label;

    @Basic
    @Column(name = "game_price")
    private double price;

    @Basic
    @Column(name = "game_company")
    private String company;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "fk_game_player_id"))
    private PlayerDTO owner;

    public GameDTO(int id, String label, double price, String company) {
        this(label, price, company);
        this.id = id;
    }

    public GameDTO(String label, double price, String company) {

        this.label = label;
        this.price = price;
        this.company = company;
    }

    public GameDTO(String label, double price, String company, PlayerDTO owner) {
        this.owner = owner;
        this.label = label;
        this.price = price;
        this.company = company;
    }


    public GameDTO() {
        //default
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public PlayerDTO getOwner() {
        return owner;
    }

    public void setOwner(PlayerDTO owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GameDTO)) {
            return false;
        }
        GameDTO gameDTO = (GameDTO) o;
        return id == gameDTO.id &&
            Double.compare(gameDTO.price, price) == 0 &&
            Objects.equals(label, gameDTO.label) &&
            Objects.equals(company, gameDTO.company);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, label, price, company);
    }

    @Override
    public String toString() {
        return "GameDTO{" +
            "id=" + id +
            ", label='" + label + '\'' +
            ", price=" + price +
            ", company='" + company + '\'' +
            ", owner=" + owner +
            '}';
    }
}
