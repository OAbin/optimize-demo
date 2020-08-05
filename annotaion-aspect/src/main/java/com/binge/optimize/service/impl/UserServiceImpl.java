package com.binge.optimize.service.impl;

import com.binge.optimize.domain.Log;
import com.binge.optimize.domain.User;
import com.binge.optimize.mapper.UserMapper;
import com.binge.optimize.service.CacheService;
import com.binge.optimize.service.LogService;
import com.binge.optimize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private LogService logService;

    @Override
    public void addUser(User user) {
        userMapper.addUser(new User());
    }

    @Override
    public User userById(Integer id) {
        //查询缓存
        User user = cacheService.getCache(id.toString());
        if (null == user){
            //日志记录
            logService.addLog(new Log());
            user = userMapper.userById(id);
            cacheService.addCache(id.toString(), user);
            //日志记录
            logService.addLog(new Log());
        }
        return user;
    }
}
