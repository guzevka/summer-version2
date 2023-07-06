package ru.summerversion2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.summerversion2.models.Role;
import ru.summerversion2.models.User;
import ru.summerversion2.repositories.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user){
        String email = user.getEmail();
        if(userRepository.findByEmail(email) != null) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // чел по дефолту User
        user.getRoles().add(Role.ROLE_USER);
        log.info("saving new user with email: {}", email);
        userRepository.save(user);
        return true;
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
