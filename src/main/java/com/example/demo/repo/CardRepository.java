package com.example.demo.repo;

import com.example.demo.db.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for <code>Card</code> domain objects.
 *
 * @author Selvin Castillo
 */
public interface CardRepository extends JpaRepository<Card, Long> {
}
