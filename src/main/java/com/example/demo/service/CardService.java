package com.example.demo.service;

import com.example.demo.db.Card;
import com.example.demo.db.User;
import com.example.demo.repo.CardRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service responsible for managing user cards
 *
 * @author Selvin Castillo
 */
@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // TODO organize when done

    /**
     * Adds a {@link Card} to a user by <code>userId</code>
     * @param userId the user id
     * @param card the card to add
     */
    public void addCard(Long userId, Card card) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        card.setUser(user);
        cardRepository.save(card);
    }

    /**
     * Removes a {@link Card} from a user by <code>userId</code> and <code>CardId</code>
     * @param userId the user id
     * @param cardId the card to remove
     */
    public void removeCard(Long userId, Long cardId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        Card card = cardRepository.findById(cardId).orElseThrow(() -> new IllegalArgumentException("Card not found with id: " + cardId));
        user.removeCard(card);
        userRepository.save(user);
    }

    /**
     * Updates {@link Card} details to a user
     * @param cardId the id of the card
     * @param newCardDetails the new card details
     */
    public void updateCard(Long cardId, Card newCardDetails) {
        Card card = cardRepository.findById(cardId).orElse(null);

        if (card != null) {
            // Update card details
            card.setName(newCardDetails.getName());
            card.setLastUsed(newCardDetails.getLastUsed());
            card.setUseBy(newCardDetails.getUseBy());
            card.setColor(newCardDetails.getColor());
        }
    }

    // TODO add methods to update timeTOUse and lastUsed

    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId).orElse(null);
    }

    public Map<Long, Card> getAllCardsFromUser(Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return user.getCards();
        }
        return new HashMap<>();
    }
}
