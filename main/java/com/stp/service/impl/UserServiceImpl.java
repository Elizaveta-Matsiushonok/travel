package com.stp.service.impl;

import com.stp.model.User;
import com.stp.repository.UserRepository;
import com.stp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 18.11.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User login(String login, String password) {
        User user = userRepository.findUserByLoginAndPassword(login, password);
        if(user == null){
            return new User();
        }
        return user;
    }

    @Override
    public User singUp(String login, String password) {
        User user = userRepository.findUserByLogin(login);
        if(user != null){
            return new User();
        }
        else {
            user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(0);
            userRepository.save(user);
            return user;
        }

    }


}
