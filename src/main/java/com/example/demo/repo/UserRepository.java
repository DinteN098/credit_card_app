package com.example.demo.repo;

import com.example.demo.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for <code>User</code> domain objects.
 *
 * @author Selvin Castillo
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
