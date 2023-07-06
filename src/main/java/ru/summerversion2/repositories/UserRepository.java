package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.summerversion2.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}