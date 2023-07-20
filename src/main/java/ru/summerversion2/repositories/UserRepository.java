package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.summerversion2.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAll();
    User findByIdentifier(String identifier);
    Optional<User> findById(Long id);
}