package com.stp.service;

import com.stp.model.User;

/**
 * Created by User on 18.11.2017.
 */
public interface UserService {

    User login(String login, String password);

    User singUp(String login, String password);
}
