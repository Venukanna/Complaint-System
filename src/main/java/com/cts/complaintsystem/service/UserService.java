package com.cts.complaintsystem.service;





import com.cts.complaintsystem.model.User;
import com.cts.complaintsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user != null && user.getPassword().equals(password))
            return user;
        return null;
    }
}



