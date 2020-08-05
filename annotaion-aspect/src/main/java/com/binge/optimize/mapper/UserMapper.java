package com.binge.optimize.mapper;

import com.binge.optimize.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

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
