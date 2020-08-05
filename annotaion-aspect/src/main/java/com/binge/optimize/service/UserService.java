package com.binge.optimize.service;

import com.binge.optimize.domain.User;

public interface UserService {

    /**
     * @param user
     */
    void addUser(User user);

    /**
     *
     * @param id
     * @return
     */
    User userById(Integer id);
}
