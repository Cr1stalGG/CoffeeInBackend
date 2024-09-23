package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "owner",
            orphanRemoval = true
    )
    private List<Card> cards;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "owner",
            orphanRemoval = true
    )
    private List<Order> orders;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "accounts_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public UUID getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Image getImage() {
        return image;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
