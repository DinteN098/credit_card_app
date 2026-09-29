package com.example.demo.controller;

import com.example.demo.db.Card;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cards")
public class CardController {
// TODO Once done with project organize all methods

    @Autowired
    private CardService cardService;

    @PostMapping("/add/{userId}")
    public String addCard(@PathVariable Long userId, @RequestBody Card card) {
        cardService.addCard(userId, card);
        return "Card successfully added";
    }

    @GetMapping("/{cardId}")
    public Card getCardById(@PathVariable Long cardId) {
        return cardService.getCardById(cardId);
    }

    @GetMapping("/{userId}/getAllCards")
    public Map<Long, Card> getAllCardsFromUser(@PathVariable Long userId) {
        return cardService.getAllCardsFromUser(userId);
    }

    @PostMapping("/update/{cardId}")
    public String updateCard(@PathVariable Long cardId, @RequestBody Card card) {
        cardService.updateCard(cardId, card);
        return "Card successfully updated";
    }

    @PostMapping("remove/{userId}")
    public String removeCardById(@PathVariable Long userId, @RequestParam Long cardId) {
        cardService.removeCard(userId, cardId);
        return "Card successfully removed";
    }
}
