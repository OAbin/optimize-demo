package com.binge.concurrent.service;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RemoteServiceImpl {

    public Map<String, String> userById(String id){
        Map map = new HashMap();
        map.put("id", id);
        map.put("name", "xiaohong");
        return map;
    }

    public List<Map<String, String>> usersByIds(List<Map<String, String>> maps){
        Map map1 = new HashMap();
        map1.put("id", "123");
        map1.put("name", "xiaohong");

        Map map2 = new HashMap();
        map2.put("id", "234");
        map2.put("name", "xiaohong");
        return Arrays.asList(map1, map2);
    }
}
