package com.binge.optimize.service.impl;

import com.binge.optimize.domain.User;
import com.binge.optimize.service.CacheService;
import org.springframework.stereotype.Service;


@Service
public class CacheServiceImpl implements CacheService {

    @Override
    public void addCache(String key, Object value) {
        System.out.println("缓存数据服务");
    }

    @Override
    public User getCache(String key) {
        return new User();
    }
}
