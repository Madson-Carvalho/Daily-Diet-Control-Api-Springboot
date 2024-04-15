package com.DailyDietControlApiSpringboot.service;

import com.DailyDietControlApiSpringboot.model.User;
import com.DailyDietControlApiSpringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
