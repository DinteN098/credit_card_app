package com.example.demo.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name", nullable = true)
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @MapKey(name = "cardId")
    private Map<Long, Card> cards = new HashMap<>();

    public void addCard(Card card) {
        cards.put(card.getCardId(), card);
        card.setUser(this);
    }
    public void removeCard(Card card) {
        cards.remove(card.getCardId());
        card.setUser(null);
    }
}
