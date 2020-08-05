package com.binge.optimize.service;

import com.binge.optimize.domain.User;

public interface CacheService {

    /**
     *
     * @param key
     * @param value
     */
    void addCache(String key, Object value);

    /**
     *
     * @param key
     * @return
     */
    User getCache(String key);
}
